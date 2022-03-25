class Solution {
    public int countPrimes(int n) {
        boolean dp[]=new boolean[n];
        Arrays.fill(dp,true);
        for(int i=2;i<n;i++){
            if(!dp[i]) continue;
            
            for(int j=i*2;j<n;j+=i){
                dp[j]=false;
            }
        }
        int ans=0;
        for(int i=2;i<n;i++){
            if(dp[i]) ans++;
        }
        return ans;
    }
}