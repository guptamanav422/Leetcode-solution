class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        long k=k1+k2;
        
        long arr[]=new long[100001];
        int n=nums1.length;
        for(int i=0;i<n;i++){
            arr[Math.abs(nums1[i]-nums2[i])]++;
        }
        
        for(int i=100000;i>0 && k>0;i--){
            
            long a=Math.min(k,arr[i]);
            arr[i]-=a;
            arr[i-1]+=a;
            k-=a;
        }
        long ans=0;
        for(int i=1;i<=100000;i++){
            ans+=arr[i]*((long)i*(long)i);
        }
        return ans;
    }
}