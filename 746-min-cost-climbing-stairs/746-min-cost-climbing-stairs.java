class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return memoize(cost,dp,n);
    }
    int memoize(int cost[],int dp[],int n)
    {
        if(n==0 || n==1) return 0;
        if(dp[n]!=-1) return dp[n];
        int num1=memoize(cost,dp,n-1)+cost[n-1];
        int num2=memoize(cost,dp,n-2)+cost[n-2];
        dp[n]=Math.min(num1,num2);
        return dp[n];
    }
}