class Solution {
    public int searchInsert(int[] nums, int target)
    {
        int s=0,e=nums.length-1;
        if(nums[e]<target) return e+1;
        // int ans=0;
        while(s<e){
            int m=(s+e)/2;
            if(nums[m]==target) return m;
            else if(nums[m]<target){
                s=m+1;
            }
            else{
                e=m;
            }
        }
        return s;
    }
}