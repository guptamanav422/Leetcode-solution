class Solution {
    public boolean isPalindrome(int x) {
        
        if(x<0) return false;
        
        String a=new StringBuilder(x+"").reverse().toString();
        return a.equals(x+"");
    }
}