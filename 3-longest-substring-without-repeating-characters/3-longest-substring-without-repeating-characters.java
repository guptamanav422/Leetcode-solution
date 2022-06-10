class Solution {
    public int lengthOfLongestSubstring(String s)
    {
        int hash[]=new int[300];
        Arrays.fill(hash,-1);
        int s1=-1,ans=0;
        for(int i=0;i<s.length();i++)
        {
            int ind=s.charAt(i);
            if(hash[ind]!=-1) s1=Math.max(s1,hash[ind]);
            if(i-s1>ans) ans=i-s1;
            hash[ind]=i;
        }
        return ans;
    }
}