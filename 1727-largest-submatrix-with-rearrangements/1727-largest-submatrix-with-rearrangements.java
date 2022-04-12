class Solution {
    public int largestSubmatrix(int[][] matrix) {
        
        int n=matrix.length;
        int m=matrix[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<m;j++){
                
                if(matrix[i][j]==0) continue;
                if(i!=0) matrix[i][j]+=matrix[i-1][j];
                list.add(matrix[i][j]);
            }
            Collections.sort(list,Collections.reverseOrder());
            
            for(int j=0;j<list.size();j++){
                ans=Math.max(ans,list.get(j)*(j+1));
            }
        }
        return ans;
    }
}