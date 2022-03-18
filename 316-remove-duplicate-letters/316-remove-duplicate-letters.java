class Solution
{
    public String removeDuplicateLetters(String s)
    {
        int arr[]=new int[26];
        for(char ch:s.toCharArray())
        {
            arr[ch-'a']++; 
        }
        Stack<Character> st=new Stack<>();
        boolean visited[]=new boolean[26];
        for(char ch:s.toCharArray())
        {
            int index=ch-'a';
            arr[index]--;
            if(visited[index]) continue;
            while(!st.isEmpty() && st.peek()>ch && arr[st.peek()-'a']!=0)
            {
                visited[st.pop()-'a']=false;
            }
            visited[index]=true;
            st.push(ch);
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
            sb.append(st.pop());
        return sb.reverse().toString();
    }
}