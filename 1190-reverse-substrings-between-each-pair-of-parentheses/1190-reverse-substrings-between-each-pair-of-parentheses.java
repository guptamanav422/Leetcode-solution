class Solution {
    public String reverseParentheses(String s) {
        
        Stack<Character> st=new Stack<>();        
        for(char ch:s.toCharArray()){
            if(ch==')'){
                Queue<Character> temp=new LinkedList<>();
                
                while(st.peek()!='(') temp.add(st.pop());
                st.pop();
                while(!temp.isEmpty()) st.push(temp.remove());
            }
            else st.push(ch);
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}