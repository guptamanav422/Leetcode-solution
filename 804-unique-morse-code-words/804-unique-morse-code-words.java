class Solution
{
    public int uniqueMorseRepresentations(String[] words)
    {
        String arr[]=new String[]{".-","-...","-.-.","-..",".","..-.",
        "--.","....","..",".---","-.-",".-..","--","-.","---",".--.",
        "--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> st=new HashSet<>();
        for(int i=0;i<words.length;i++)
        {
            StringBuffer sb=new StringBuffer();
            for(int j=0;j<words[i].length();j++)
            {
                sb.append(arr[words[i].charAt(j)-'a']);
            }
            st.add(sb.toString());
        }
        return st.size();
    }
}