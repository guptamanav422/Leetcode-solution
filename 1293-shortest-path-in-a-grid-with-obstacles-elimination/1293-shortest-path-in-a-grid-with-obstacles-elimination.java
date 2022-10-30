class Solution {
    int x[]={0,0,1,-1};
    int y[]={1,-1,0,0};
    public int shortestPath(int[][] grid, int k)
    {
        int n=grid.length;
        int m=grid[0].length;
        boolean visit[][][]=new boolean[n][m][k+1];
        Queue<int []> q=new LinkedList<>();
        q.add(new int[]{0,0,0});
        visit[0][0][0]=true;
        int count=0;
        while(!q.isEmpty())
        {
            int s=q.size();
            while(s-->0)
            {
                int arr[]=q.remove();
                int i=arr[0];
                int j=arr[1];
                int k1=arr[2];
                if(i==n-1 && j==m-1) return count;
                for(int l=0;l<4;l++)
                {
                    int i1=i+x[l];
                    int j1=j+y[l];
                    int currk=k1;
                    if(i1<0 || i1==n || j1<0 || m==j1) continue;
                    
                    if(grid[i1][j1]==1) currk++;
                    
                    if(currk<=k && !visit[i1][j1][currk])
                    {
                        visit[i1][j1][currk]=true;
                        q.add(new int[]{i1,j1,currk});
                    }
                }
            }
            count++;
        }
        return -1;
    }
}