class Solution {
    public String removeDuplicateLetters(String s) {
        
        boolean vis[]=new boolean[26];
        int fre[]=new int[26];
        for(char ch:s.toCharArray()){
            fre[ch-'a']++;
        }
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            
            while(!st.isEmpty() && !vis[ch-'a'] && st.peek()>=ch && fre[st.peek()-'a']>0){
                vis[st.pop()-'a']=false;
            }
            // System.out.print(st.isEmpty()?-1:((char)st.peek()));
            // System.out.print(" ");
            fre[ch-'a']--;
            if(!vis[ch-'a']){          
                vis[ch-'a']=true;
                st.push(ch);   
            }
            // System.out.println((Character)st.peek());
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}