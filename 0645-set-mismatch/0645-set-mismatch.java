class Solution {
    public int[] findErrorNums(int[] nums) {
        
        int ans[]=new int[2];
        for(int i=0;i<nums.length;i++){
            
            while(nums[nums[i]-1]!=nums[i]){
                int temp=nums[i];
                
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
            }
        }
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                ans[0]=nums[i];
                ans[1]=i+1;
            }
        }
        return ans;
    }
}