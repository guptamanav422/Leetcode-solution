class Solution
{
    public int[] searchRange(int[] nums, int target)
    {
        int i=0,j=nums.length-1,left=-1,right=-1;
        while(i<=j)
        {
            int m=(i+j)/2;
            if(nums[m]>target) j=m-1;
            else if(nums[m]<target) i=m+1;
            else
            {
                left=m;
                j=m-1;
            }
        }
        if(left==-1) return new int[]{-1,-1};
        i=0;j=nums.length-1;
        while(i<=j)
        {
            int m=(i+j)/2;
            if(nums[m]>target) j=m-1;
            else if(nums[m]<target) i=m+1;
            else
            {
                right=m;
                i=m+1;
            }
        }
        return new int[]{left,right};
    }
}