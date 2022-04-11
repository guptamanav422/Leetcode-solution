class Solution {
    public boolean[] canEat(int[] arr1, int[][] queries) {
        
        
        int n=queries.length;
        boolean ans[]=new boolean[n];
        long arr[]=new long[arr1.length];
        arr[0]=(long)arr1[0];
        for(int i=1;i<arr.length;i++){
            arr[i]=arr[i-1]+arr1[i];
        }
        // for(long a:arr){
        //     System.out.print(a+" ");
        // }
        for(int i=0;i<n;i++){
            long num=(queries[i][0]==0)?0:arr[queries[i][0]-1];
            
            long total=(long)(queries[i][1]+1)*(long)queries[i][2];
            
            if((queries[i][1]+1)<=arr[queries[i][0]] && total>num) ans[i]=true;
        }
        return ans;
    }
}