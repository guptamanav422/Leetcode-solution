class Solution {
    public int minimumWhiteTiles(String floor, int num, int len) {
        
        char arr[]=floor.toCharArray();
        int n=arr.length;
        if(num*len>=n) return 0;
        
        int dp[][]=new int[n][num+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=num;j++){
                
                if(j*len>=(i+1)) dp[i][j]=0;
                else{
                    if(j==0) dp[i][j]=(i==0?0:dp[i-1][j])+(arr[i]-'0');
                    else dp[i][j]=Math.min(dp[i-1][j]+(arr[i]-'0'),dp[i-len][j-1]);
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<=num;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return dp[n-1][num];
    }
}