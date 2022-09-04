class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        
        
        int n=nums.length,ans=0;
        int el=n,ma=n;
        
        for(int i=nums.length-1;i>=0;i--){
            
            if(nums[i]>right) ma=i;
            else if(nums[i]>=left && nums[i]<=right) el=i;
            
            ans+=Math.max(0,ma-el);
            // System.out.println(ans);
        }
        return ans;
    }
}