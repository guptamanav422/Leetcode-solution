class Solution {
    public int coinChange(int[] coins, int amount)
    {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int a:coins)
        {
            for(int i=a;i<=amount;i++)
            {
                if(dp[i-a]!=Integer.MAX_VALUE)
                {
                    dp[i]=Math.min(dp[i],dp[i-a]+1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}