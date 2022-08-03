class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int ans=0,i=0;
        for(char ch:s.toCharArray()){
            if(st.peek()!=-1 && s.charAt(st.peek())=='(' && ch==')'){
                st.pop();
                ans=Math.max(ans,i-st.peek());
            }
            else st.push(i);
            i++;
        }
        return ans;
    }
}