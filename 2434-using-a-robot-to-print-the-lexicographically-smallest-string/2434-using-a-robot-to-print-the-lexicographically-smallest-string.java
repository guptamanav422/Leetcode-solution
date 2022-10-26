class Solution {
    public String robotWithString(String s) {
        
        int n=s.length();
        
        int arr[]=new int[26];
        for(char ch:s.toCharArray()){
            arr[ch-'a']++;
        }
        
        StringBuilder sb=new StringBuilder();
        
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            
            st.push(ch);
            arr[ch-'a']--;
            
            
            
            while(!st.isEmpty()){
                
                boolean ok=true;
                
                ch=st.peek();
                for(int i=ch-'a'-1;i>=0 && ok;i--){
                    if(arr[i]!=0){
                        ok=false;
                    }
                }
                
                if(ok){
                    sb.append(st.pop());
                }
                else break;
            }
        }
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.toString();
    }
}