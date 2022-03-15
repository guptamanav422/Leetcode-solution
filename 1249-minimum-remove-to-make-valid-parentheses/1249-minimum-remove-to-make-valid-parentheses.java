class Solution {
    public String minRemoveToMakeValid(String s)
    {
        StringBuffer sb=new StringBuffer();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(') st.push(sb.length());
            else if(s.charAt(i)==')'){
                if(!st.isEmpty()){
                    st.pop();
                }
                else continue;
            }
            sb.append(s.charAt(i));
        }
        while(!st.isEmpty())
        {
            int num=st.pop();
            sb.delete(num,num+1);
        }
        return sb.toString();
    }
}