class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        int c=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            
            if(ch=='('){
                st.push(c);
                c=0;
            }
            else{
                c=st.pop() + Math.max(c*2,1);
            }
        }
        return c;
    }
}