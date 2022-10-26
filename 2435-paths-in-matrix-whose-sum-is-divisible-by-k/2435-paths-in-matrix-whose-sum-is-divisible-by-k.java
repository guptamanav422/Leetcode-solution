class Solution {
    int dp[][][];
    public int numberOfPaths(int[][] grid, int k) {
        
        int n=grid.length,m=grid[0].length;
        dp=new int[n][m][k];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return find(0,0,grid,0,k);
    }
    int find(int i,int j,int grid[][],int sum,int k){
        
        
        if(i==grid.length-1 && j==grid[0].length-1){
            
            return (sum+grid[i][j])%k==0?1:0;
        }
        
        if(dp[i][j][sum]!=-1) return dp[i][j][sum];
        long count=0;
        
        if(i!=grid.length-1){
            count+=find(i+1,j,grid,(sum+grid[i][j])%k, k);
        }
        if(j!=grid[0].length-1){
            count+=find(i,j+1,grid,(sum+grid[i][j])%k, k);
        }
        
        return dp[i][j][sum]=(int)(count%1000000007);
        
        
    }
}