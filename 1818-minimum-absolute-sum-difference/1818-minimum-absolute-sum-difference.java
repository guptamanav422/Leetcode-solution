class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        
        
        int n=nums1.length;
        int temp[]=new int[n];
        for(int i=0;i<n;i++){
            temp[i]=nums1[i];
        }
        
        Arrays.sort(temp);
        int ma=0;
        long ans=0;
        for(int i=0;i<n;i++){
            
            int idx=Arrays.binarySearch(temp,nums2[i]);
            if(idx<0){
                idx=-(idx+1);
            }
            int abs=Math.abs(nums1[i]-nums2[i]);
            int abs1=Integer.MAX_VALUE;
            if(idx!=n){
                abs1=Math.min(abs1,Math.abs(temp[idx]-nums2[i]));
            }
            if(idx!=0){
                abs1=Math.min(abs1,Math.abs(temp[idx-1]-nums2[i]));
            }
            // System.out.println(abs+" "+abs1);
            ma=Math.max(ma,abs-abs1);
            ans+=abs;
        }
        // System.out.println(ma);
        return (int)((ans-ma)%1000000007);
    }
}