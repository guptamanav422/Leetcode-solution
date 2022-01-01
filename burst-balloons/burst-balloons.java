class Solution {
    public int maxCoins(int[] nums)
    {
        int n=nums.length;
        int dp[][]=new int[n][n];
        for(int gap=0;gap<n;gap++)
        {
            for(int i=0,j=gap;j<n;i++,j++)
            {
                if(gap==0){
                    int num=nums[i];
                    if(i!=0) num=num*nums[i-1];
                    if(i!=n-1) num*=nums[i+1];
                    dp[i][j]=num;
                }
                else{
                    int num=0;
                    for(int k=i;k<=j;k++)
                    {
                        int temp=0;
                        if(k!=i) temp+=dp[i][k-1];
                        if(k!=j) temp+=dp[k+1][j];
                        int temp1=nums[k];
                        if(i!=0) temp1*=nums[i-1];
                        if(j!=n-1) temp1*=nums[j+1];
                        temp+=temp1;
                        num=Math.max(num,temp);
                    }
                    dp[i][j]=num;
                }
            
        }
        }
        return dp[0][n-1];
    }
}