class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        Arrays.sort(nums);
        
        int n=nums.length,j=n/2+1;
        for(int i=0;i<n-1;i+=2){
            int temp=nums[i];
            nums[i]=nums[i+1];
            nums[i+1]=temp;
        }
        return nums;
    }
}