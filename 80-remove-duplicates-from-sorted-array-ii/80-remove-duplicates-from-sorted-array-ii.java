class Solution {
    public int removeDuplicates(int[] nums)
    {
        int i=0,idx=0,n=nums.length;
        while(i<n)
        {
            nums[idx]=nums[i];
            i++;
            idx++;
            int count=1;
            while(i<n && nums[i-1]==nums[i]){
                count++;
                if(count<=2){
                    nums[idx++]=nums[i];
                }
                i++;
            }
        }
        return idx;
    }
}