class Solution {
    public int numberOfArithmeticSlices(int[] nums)
    {
        int ans=0;
        int s=0,n=nums.length,diff=-100000;
        for(int i=1;i<n;i++){
            
            if(nums[i]-nums[i-1]!=diff || diff==-100000){
                diff=nums[i]-nums[i-1];
                s=i-1;
            }
            
            ans+=(i-s-1);
        }
        return ans;
    }
}