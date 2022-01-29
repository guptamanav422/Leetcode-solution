class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]) st.pop();
            
            st.push(i);
        }
        
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]) st.pop();
            
            ans[i]=(st.isEmpty())?-1:nums[st.peek()];
            st.push(i);
        }
        return ans;
    }
}