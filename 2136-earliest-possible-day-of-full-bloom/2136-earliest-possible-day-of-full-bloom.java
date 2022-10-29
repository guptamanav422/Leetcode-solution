class Solution {
    public int earliestFullBloom(int[] plant, int[] grow) {
        
        int n=plant.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=plant[i];
            arr[i][1]=grow[i];
        }
        Arrays.sort(arr,(int a[],int b[])->(b[1]-a[1]));
        int ans=0;
        int prev=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,prev+arr[i][0]+arr[i][1]);
            prev+=arr[i][0];
        }
        return ans;
    }
}