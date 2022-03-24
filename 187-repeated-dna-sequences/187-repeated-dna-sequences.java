class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        Map<String,Integer> map=new HashMap<>();
        List<String> ans=new ArrayList<>();
        int n=s.length();
        for(int i=9;i<n;i++){
            String ss=s.substring(i-9,i+1);
            // System.out.println(ss);
            int aa=map.getOrDefault(ss,0);
            if(aa==1){
                ans.add(ss);
            }
            map.put(ss,aa+1);
        }
        return ans;
    }
}