class Solution {
    public int numDecodings(String s)
    {
        int a=1,b=s.charAt(0)=='0'?0:1;
        for(int i=1;i<s.length();i++)
        {
            int c=s.charAt(i)=='0'?0:b;
            int num=Integer.parseInt(s.substring(i-1,i+1));
            c+=(num>=10 && num<=26)?a:0;
            a=b;
            b=c;
        }
        return b;
    }
}