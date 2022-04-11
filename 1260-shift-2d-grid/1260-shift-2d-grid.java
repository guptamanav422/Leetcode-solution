class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        int n=grid.length,m=grid[0].length;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
            for(int j=0;j<m;j++){
                list.get(i).add(0);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                int idx=(i*m+j+k)%(n*m);
                
                int i1=idx/m,j1=idx%m;
                list.get(i1).set(j1,grid[i][j]);
            }
        }
        return list;
    }
}