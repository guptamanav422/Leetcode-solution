class Solution {
    public int romanToInt(String s)
    {
        int hash[]=new int[26];
        hash['I'-'A']=1;
        hash['V'-'A']=5;
        hash['X'-'A']=10;
        hash['L'-'A']=50;
        hash['C'-'A']=100;
        hash['D'-'A']=500;
        hash['M'-'A']=1000;
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            int ind=s.charAt(i)-'A';
            ans+=hash[ind];
            if(i!=0 && hash[s.charAt(i-1)-'A']<hash[ind]) ans-=2*hash[s.charAt(i-1)-'A'];
        }
        return ans;
    }
}