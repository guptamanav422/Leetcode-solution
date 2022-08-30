class Solution {
    int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
    public int swimInWater(int[][] grid) {
        
        int n=grid.length;
        Queue<int []> pq=new PriorityQueue<>((int a[],int b[])->a[2]-b[2]);
        pq.add(new int[]{0,0,grid[0][0]});
        
        while(!pq.isEmpty()){
            
            int arr[]=pq.remove();
            
            if(arr[0]==n-1 && arr[1]==n-1) return arr[2];
            
            if(grid[arr[0]][arr[1]]==Integer.MAX_VALUE) continue;
            grid[arr[0]][arr[1]]=Integer.MAX_VALUE;
            for(int k=0;k<4;k++){
                
                int i=arr[0] + dir[k][0];
                int j=arr[1] + dir[k][1];
                
                if(i<0 || j<0 ||i==n || j==n || grid[i][j]==Integer.MAX_VALUE) continue;
                
                pq.add(new int[]{i,j,Math.max(arr[2],grid[i][j])});
            }
        }
        return -1;
    }
}