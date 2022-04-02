class Solution {
    public boolean validPalindrome(String s)
    {
        return find(s,0,s.length()-1);
    }
    boolean find(String str,int s,int e)
    {
        if(s>=e) return true;
        if(str.charAt(s)==str.charAt(e)) return find(str,s+1,e-1);
        else return check(str,s,e-1) || check(str,s+1,e);
    }
    boolean check(String str,int s,int e)
    {
        while(s<e)
        {
            if(str.charAt(s)!=str.charAt(e)) return false;
            s++;
            e--;
        }
        return true;
    }
}