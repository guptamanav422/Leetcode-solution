class Solution {
    public int rob(int[] nums) {
        
        int prev=0,prev1=0;
        for(int a:nums){
            int b=Math.max(prev,prev1+a);
            
            prev1=prev;
            prev=b;
        }
        return prev;
    }
}