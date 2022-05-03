class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int s=-1,e=-2,n=nums.length;
        int min = nums[n-1], max = nums[0];
        for(int i=0;i<nums.length;i++){
            
            min=Math.min(min,nums[n-1-i]);
            max=Math.max(max,nums[i]);
            
            if(max>nums[i]) e=i;
            if(min<nums[n-1-i]) s=n-1-i;
            // System.out.print(s+" ");
        }
        return e-s+1;
    }
}