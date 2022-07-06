class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n=nums1.length,m=nums2.length;
        if(n>m) return findMedianSortedArrays(nums2,nums1);
        
        
        int s=0,e=n;
        while(s<=e){
            
            int m1=(s+e)/2;
            
            int l1=(m1==0)?(Integer.MIN_VALUE):(nums1[m1-1]);
            int r1=(m1==n)?(Integer.MAX_VALUE):(nums1[m1]);
            
            int m2=(n+m)/2-m1;
            
            int l2=(m2==0)?(Integer.MIN_VALUE):(nums2[m2-1]);
            int r2=(m2==m)?(Integer.MAX_VALUE):(nums2[m2]);
            
            if(l1<=r2 && l2<=r1){
                
                if((n+m)%2==0){
                    
                    return (double)((double)(Math.max(l1,l2)) +(double)(Math.min(r1,r2)))/2.0;
                }
                else return (double)(Math.min(r1,r2));
            }
            else if(l1>r2){
                e=m1-1;
            }
            else s=m1+1;
        }
        return 0.0;
    }
}