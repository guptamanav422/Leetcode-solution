class Solution {
    public int missingNumber(int[] nums) {
        int num=0;
        for(int i=0;i<nums.length;i++){
            num^=nums[i];
            num^=i;
        }
        num^=nums.length;
        return num;
    }
}