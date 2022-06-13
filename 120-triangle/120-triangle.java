class Solution {
    public int minimumTotal(List<List<Integer>> triangle)
    {
        int len=triangle.size();
        int dp[]=new int[len];
        dp[0]=triangle.get(0).get(0);
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<len;i++)
        {
            for(int j=i;j>=0;j--)
            {
                int num=Integer.MAX_VALUE;
                if(j!=i) num=Math.min(num,dp[j]);
                if(j!=0) num=Math.min(num,dp[j-1]);
                num+=triangle.get(i).get(j);
                dp[j]=num;
                if(i==len-1) ans=Math.min(ans,dp[j]);
            }
        }
        return ans==Integer.MAX_VALUE?dp[0]:ans;
    }
}