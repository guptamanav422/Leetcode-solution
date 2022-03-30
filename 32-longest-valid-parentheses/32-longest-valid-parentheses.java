class Solution {
    public int longestValidParentheses(String s) {
        int ans=0;
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            if(ch=='(') st.push(i);
            else if(st.peek()!=-1 && s.charAt(st.peek())=='('){
                st.pop();
                ans=Math.max(ans,i-st.peek());
            }
            else st.push(i);
        }
        return ans;
    }
}