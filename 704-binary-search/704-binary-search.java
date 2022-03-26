class Solution
{
    int found(int[] nums,int target,int s,int e)
    {
        if(s>e) return -1;
        int mid=(s+e)/2;
        if(nums[mid]==target) return mid;
        else if(nums[mid]>target) return found(nums,target,s,mid-1);
        else return found(nums,target,mid+1,e);
    }
    public int search(int[] nums, int target)
    {
        return found(nums,target,0,nums.length-1);
    }
}