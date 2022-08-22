class Solution {
    public int longestPalindrome(String s)
    {
        int arr[]=new int[150];
        int ans=0;
        for(char ch:s.toCharArray())
        {
            arr[ch]++;
            if(arr[ch]%2==0) ans+=2;
        }
        return ans==s.length()?ans:ans+1;
    }
}