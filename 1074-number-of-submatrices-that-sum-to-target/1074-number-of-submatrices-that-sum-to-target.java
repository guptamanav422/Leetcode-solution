class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int n=matrix.length,m=matrix[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            int arr[]=new int[m];
            for(int j=i;j<n;j++){
                Map<Integer,Integer> map=new HashMap<>();
                map.put(0,1);
                int a=0;
                for(int k=0;k<m;k++){
                    arr[k]+=matrix[j][k];
                    a+=arr[k];
                    ans+=map.getOrDefault(a-target,0);
                    map.put(a,map.getOrDefault(a,0)+1);
                }
            }
        }
        return ans;
    }
}