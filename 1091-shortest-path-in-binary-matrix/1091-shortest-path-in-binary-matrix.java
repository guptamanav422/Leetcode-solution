class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int []> q=new LinkedList<>();
        if(grid[0][0]==1) return -1;
        q.add(new int[]{0,0});
        
        int n=grid.length;
        int ans=0;
        int dir[][]={{-1,0},{1,0},{0,1},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        grid[0][0]=1;
        while(!q.isEmpty()){
            int s=q.size();
            while(s-->0){
                
                int arr[]=q.remove();
                
                if(arr[0]==n-1 && arr[1]==n-1) return ans+1;
                
                for(int k=0;k<8;k++){
                    int x=arr[0]+dir[k][0];
                    int y=arr[1]+dir[k][1];
                    
                    if(x<0 || y<0 || x==grid.length || y==grid[0].length || grid[x][y]==1) continue;
                    
                    grid[x][y]=1;
                    q.add(new int[]{x,y});
                }
            }
            ans++;
        }
        return -1;
    }
}