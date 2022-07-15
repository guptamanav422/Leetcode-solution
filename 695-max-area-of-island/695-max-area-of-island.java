class Solution {
    int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
        
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans=Math.max(ans,dfs(grid,i,j));
                }
            }
        }
        return ans;
    }
    int dfs(int arr[][],int i,int j){
        if(i<0 || j<0 || i==arr.length || j==arr[0].length || arr[i][j]==0) return 0;
        
        int ans=0;
        arr[i][j]=0;
        for(int k=0;k<4;k++){
            ans+=dfs(arr,i+dir[k][0],j+dir[k][1]);
        }
        return ans+1;
    }
}