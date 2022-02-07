class Solution {
    public char findTheDifference(String s, String t) {
        int num=0,n=s.length();
        for(int i=0;i<n;i++){
            num^=s.charAt(i);
            num^=t.charAt(i);
        }
        num^=t.charAt(n);
        return (char)num;
    }
}