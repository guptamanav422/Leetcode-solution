class Solution {
    public int uniquePaths(int n, int m) {
        int dp[][]=new int[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 || j==m-1){
                    dp[i][j]=1;
                }
                else dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}