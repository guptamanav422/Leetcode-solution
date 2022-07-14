class Solution {
    public long wonderfulSubstrings(String word) {
        
        Map<Integer,Integer> m1=new HashMap<>();
        
        long ans=0;
        int num=0;
        m1.put(0,1);
        for(char ch:word.toCharArray()){
            
            num^=1<<(ch-'a');
            ans+=m1.getOrDefault(num,0);
            
            for(int i=0;i<=9;i++){
                ans+=m1.getOrDefault((num^(1<<i)),0);
            }
            m1.put(num,m1.getOrDefault(num,0)+1);
            
        }
        return ans;
        
    }
}