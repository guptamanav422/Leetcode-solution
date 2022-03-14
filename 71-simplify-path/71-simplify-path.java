class Solution {
    public String simplifyPath(String s) {
        Stack<String> st=new Stack<>();
        
        int n=s.length();
        String temp="";
        for(int i=1;i<n;i++){
            
            char ch=s.charAt(i);
            if(ch=='/'){
                if(!temp.equals("")){
                    st.push(temp);
                }
            }
            else{
                if(i!=n-1 && s.charAt(i)=='.' && s.charAt(i+1)=='.' && (i==n-2 || s.charAt(i+2)=='/')){
                    if(!st.isEmpty()) st.pop();
                    i++;
                }
                else{
                    while(i<n && s.charAt(i)!='/'){
                        temp+=s.charAt(i);
                        i++;
                    }
                    if(!temp.equals(".")) st.push(temp);
                    temp="";
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(new StringBuilder(st.pop()).reverse()+"/");
        }
        
        if(sb.length()==0) return "/";
        return sb.reverse().toString();
    }
}