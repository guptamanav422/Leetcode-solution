class Solution {
    public String breakPalindrome(String str) {
        
        int len=str.length();
        if(len==1) return "";
        
        for(int i=0;i<len/2;i++){
            if(str.charAt(i)!='a') return str.substring(0,i)+'a'+str.substring(i+1);
        }
        return str.substring(0,len-1)+'b';
    }
}