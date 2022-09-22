class Solution {
    public String reverseWords(String s) {
        StringBuffer sb=new StringBuffer();
        StringBuffer temp=new StringBuffer();
        for(char ch:s.toCharArray()){
            if(ch==' '){
                sb.append(temp.reverse()+" ");
                temp=new StringBuffer();
            }
            else{
                temp.append(ch);
            }
        }
        sb.append(temp.reverse());
        return sb.toString();
    }
}