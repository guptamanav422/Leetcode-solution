class Solution {
    class pair{
        char ch;
        int c;
        pair(char ab,int a){
            ch=ab;
            c=a;
        }
    }
    public String removeDuplicates(String s, int k) {
        
        Stack<pair> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char a=s.charAt(i);
            
            if(st.isEmpty() || st.peek().ch!=a) st.push(new pair(a,1));
            else st.peek().c++;
            
            if(st.peek().c==k) st.pop();
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            pair temp=st.pop();
            for(int i=1;i<=temp.c;i++){
                sb.append(temp.ch);
            }
        }
        return sb.reverse().toString();
    }
}