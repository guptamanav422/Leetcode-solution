class Solution {
    public int titleToNumber(String str) {
        
        if(str.length()==0) return 0;
        else return (str.charAt(str.length()-1)-'A'+1)+(26)*titleToNumber(str.substring(0,str.length()-1));
    }
}