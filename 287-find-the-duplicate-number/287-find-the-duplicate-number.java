class Solution {
    public int findDuplicate(int[] nums) {
        
        int hare=nums[0],tor=nums[0];
        
        while(true){
            hare=nums[nums[hare]];
            tor=nums[tor];
            if(hare==tor) break;
        }
        
        hare=nums[0];
        while(hare!=tor){
            hare=nums[hare];
            tor=nums[tor];
        }
        return hare;
    }
}