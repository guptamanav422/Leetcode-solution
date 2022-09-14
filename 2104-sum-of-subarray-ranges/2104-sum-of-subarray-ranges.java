class Solution {
    public long subArrayRanges(int[] nums) {
        
        int n=nums.length;
        long ans=0;
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        for(int i=0;i<=n;i++){
            
            while(st.peek()!=-1 && (i==n || nums[st.peek()]>nums[i])){
                
                int j=st.pop();
                ans-=nums[j]*(long)(i-j)*(long)(j-st.peek());
            }
            st.push(i);
        }
        st=new Stack<>();
        st.push(-1);
        for(int i=0;i<=n;i++){
            
            while(st.peek()!=-1 && (i==n || nums[st.peek()]<nums[i])){
                
                int j=st.pop();
                ans+=nums[j]*(long)(i-j)*(long)(j-st.peek());
            }
            st.push(i);
        }
        
        return ans;
    }
}