class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=speed[i];
            arr[i][1]=efficiency[i];
        }
        
        Arrays.sort(arr,(int a[],int b[])->(a[1]-b[1]));
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        long sum=0,ans=0,mod=1000000007;
        for(int i=n-1;i>=0;i--){
            sum+=arr[i][0];
            pq.add(arr[i][0]);
            if(i<(n-k)){
                sum-=pq.remove();
            }
            ans=Math.max(ans,sum*arr[i][1]);
        }
        return (int)(ans%mod);
    }
}