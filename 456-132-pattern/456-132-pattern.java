class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st=new Stack<>();
        
        int temp=Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            
            if(temp>nums[i]) return true;
            
            while(!st.isEmpty() && nums[i]>st.peek()){
                temp=st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }
}