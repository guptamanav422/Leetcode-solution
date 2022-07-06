class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character,Integer> map=new HashMap<>();
        int n=s.length(),ans=0,ss=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                ss=Math.max(ss,map.get(ch)+1);
            }
            map.put(ch,i);
            ans=Math.max(ans,i-ss+1);
        }
        return ans;
    }
}