class Solution {
    int arr[][];
    int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length,m=heights[0].length;
        arr=new int[n][m];
        for(int i=0;i<n;i++){
            dfs(i,0,1,heights);
            dfs(i,m-1,200,heights);
        }
        for(int i=0;i<m;i++){
            dfs(n-1,i,200,heights);
            dfs(0,i,1,heights);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]>200 && arr[i][j]%200!=0) ans.add(Arrays.asList(new Integer[]{i,j}));
            }
        }
        return ans;
    }
    void dfs(int i,int j,int num,int grid[][]){
        
        if(num==1){
            if(arr[i][j]%200>=1) return;
        }
        else{
            if(arr[i][j]>=200) return;
        }
        arr[i][j]+=num;
        for(int k=0;k<4;k++){
            int x=dir[k][0]+i;
            int y=dir[k][1]+j;
            if(x<0 || y<0 || x==grid.length || y==grid[0].length || grid[x][y]<grid[i][j]) continue;
            
            dfs(x,y,num,grid);
        }
    }
}