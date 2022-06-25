class Solution {
    public boolean checkPossibility(int[] nums) {
        
        int c=0,n=nums.length;
        for(int i=1;i<n && c<=1;i++){
            
            if(nums[i-1]>nums[i]){
                c++;
                
                if(i==1 || nums[i-2]<=nums[i]){
                    nums[i-1]=nums[i];
                }
                else nums[i]=nums[i-1];
            }
        }
        return c<=1;
    }
}