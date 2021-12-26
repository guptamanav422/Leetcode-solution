class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int []> pq=new PriorityQueue<>((int a[],int b[])->(b[2]-a[2]));
        
        for(int arr[]:points){
            int dist=(arr[0])*arr[0] + arr[1]*arr[1];
            pq.add(new int[]{arr[0],arr[1],dist});
            
            if(pq.size()>k) pq.remove();
        }
        
        int ans[][]=new int[k][2];
        for(int i=0;i<k;i++){
            int temp[]=pq.remove();
            ans[i]=new int[]{temp[0],temp[1]};
        }
        return ans;
    }
}