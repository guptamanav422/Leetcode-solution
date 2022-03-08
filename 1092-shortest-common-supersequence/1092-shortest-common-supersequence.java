class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        String str=lcs(str1,str2);
        StringBuilder sb=new StringBuilder();
        
        int i=0,j=0,n=str1.length(),m=str2.length();
        
        for(int k=0;k<str.length();k++){
            
            while(i<n && str1.charAt(i)!=str.charAt(k)) sb.append(str1.charAt(i++));
            while(j<m && str2.charAt(j)!=str.charAt(k)) sb.append(str2.charAt(j++));
            
            sb.append(str.charAt(k));
            i++;
            j++;
        }
        
         while(i<n) sb.append(str1.charAt(i++));
         while(j<m) sb.append(str2.charAt(j++));
        return sb.toString();
    }
    String lcs(String a,String b){
        
        int n=a.length(),m=b.length();
        String dp[][]=new String[n+1][m+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],"");
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                if(a.charAt(i-1)==b.charAt(j-1)) dp[i][j]=dp[i-1][j-1]+a.charAt(i-1);
                else{
                    
                    if(dp[i-1][j].length()>dp[i][j-1].length()) dp[i][j]=dp[i-1][j];
                    else dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
}