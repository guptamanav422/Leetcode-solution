class Solution {
    public int countBinarySubstrings(String s) {
        
        int prev=0,curr=0,ans=0;
        for(int i=0;i<s.length();i++){
            if(i==0 || s.charAt(i)==s.charAt(i-1)) curr++;
            else{
                prev=curr;
                curr=1;
            }
            
            if(prev>=curr) ans++;
        }
        return ans;
    }
}