class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n=mat.length,m=mat[0].length;
        
        Map<Integer,PriorityQueue<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map.putIfAbsent(j-i,new PriorityQueue<>());
                map.get(j-i).add(mat[i][j]);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=map.get(j-i).poll();
            }
        }
        return mat;
    }
}