class Solution {
    public int countPalindromicSubsequences(String s) {
        int n=s.length();
        int next[]=new int[n],prev[]=new int[n];
        int hash[]=new int[4];
        Arrays.fill(hash,-1);
        int mod=1000000007;
        for(int i=0;i<s.length();i++)
        {
            int num=s.charAt(i)-'a';
            prev[i]=next[i]=-1;
            
            if(hash[num]!=-1){
                prev[i]=hash[num];
                next[hash[num]]=i;
            }
            hash[num]=i;
        }
        
        int dp[][]=new int[n][n];
        for(int g=0;g<n;g++)
        {
            for(int i=0,j=g;j<n;j++,i++)
            {
                if(g==0 || g==1){
                    dp[i][j]=g+1;
                }
                else if(s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=(dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1])%mod;
                }
                else{
                    if(next[i]==-1 || next[i]>=j){
                        dp[i][j]=((dp[i+1][j-1]*2)%mod+2)%mod;
                    }
                    else if(next[i]!=-1 && next[i]==prev[j]){
                        dp[i][j]=((dp[i+1][j-1]*2)%mod+1)%mod;
                    }
                    else{
                        int p=next[i];
                        int q=prev[j];
                        dp[i][j]=((dp[i+1][j-1]*2)%mod)-dp[p+1][q-1];
                    }
                }
                if(dp[i][j]<0) dp[i][j]+=mod;
            }
        }
        
        return dp[0][n-1];
    }
}