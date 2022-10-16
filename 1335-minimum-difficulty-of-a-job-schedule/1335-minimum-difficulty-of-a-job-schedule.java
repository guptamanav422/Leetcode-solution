class Solution {
    public int minDifficulty(int[] arr, int d)
    {
        int n=arr.length;
        if(d>n) return -1;
        int dp[][]=new int[d][n];
        for(int i=0;i<d;i++)
        {
            for(int j=i;j<n;j++)
            {
                if(i==0 && j==0) dp[i][j]=arr[j];
                else if(i==0){
                    dp[i][j]=Math.max(arr[j],dp[i][j-1]);
                }
                else if(j==i){
                    dp[i][j]=dp[i-1][j-1] + arr[j];
                }
                else{
                    int max=arr[j];
                    int num=Integer.MAX_VALUE;
                    for(int k=j-1;k>=i-1;k--)
                    {
                        num=Math.min(num,max+dp[i-1][k]);
                        max=Math.max(max,arr[k]);
                    }
                    dp[i][j]=num;
                }
            }
        }
        for(int i=0;i<d;i++)
        {
            for(int j=0;j<n;j++)
            {
               System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[d-1][n-1];
    }
}