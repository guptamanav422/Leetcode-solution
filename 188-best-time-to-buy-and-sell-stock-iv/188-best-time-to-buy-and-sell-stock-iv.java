class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(n==0 || n==1 || k==0) return 0;
        int dp[][]=new int[k][n];
        for(int i=0;i<k;i++)
        {
            int min=prices[0];
            for(int j=1;j<n;j++)
            {
                if(i==0){
                    min=Math.min(min,prices[j]);
                    dp[i][j]=Math.max(dp[i][j-1],prices[j]-min);
                }
                else{
                    min=Math.min(min,prices[j]-dp[i-1][j]);
                    dp[i][j]=Math.max(dp[i][j-1],prices[j]-min);
                }
            }
        }
        return dp[k-1][n-1];
    }
}