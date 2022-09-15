class Solution {
    
    int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
    public int getMaximumGold(int[][] grid) {
        
        int n=grid.length,m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    ans=Math.max(ans,find(grid,i,j));
                }
            }
        }
        return ans;
    }
    int find(int arr[][],int i,int j){
        
        if(i<0 || j<0 || i==arr.length || j==arr[0].length || arr[i][j]==0) return 0;
        
        int num=arr[i][j],ans=0;
        arr[i][j]=0;
        for(int k=0;k<4;k++){
            ans=Math.max(ans,find(arr,i+dir[k][0],j+dir[k][1]));
        }
        arr[i][j]=num;
        return ans+num;
    }
}