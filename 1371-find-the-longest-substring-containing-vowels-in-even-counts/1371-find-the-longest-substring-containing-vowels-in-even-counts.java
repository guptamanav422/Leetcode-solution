class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer,Integer> map=new HashMap<>();
        int curr=0,n=s.length();
        map.put(0,-1);
        int ans=0;
        String str="aeiou";
        for(int i=0;i<n;i++){
            
            curr^=1<<(str.indexOf(s.charAt(i))+1)>>1;
            map.putIfAbsent(curr,i);
            ans=Math.max(ans,i-map.get(curr));
        }
        return ans;
    }
}