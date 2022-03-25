class Solution {
    public int countPrimes(int n) {
        boolean dp[]=new boolean[n];
        Arrays.fill(dp,true);
        int ans=0;
        for(int i=2;i<n;i++){
            if(!dp[i]) continue;
            ans++;
            for(int j=i*2;j<n;j+=i){
                dp[j]=false;
            }
        }
        return ans;
    }
}