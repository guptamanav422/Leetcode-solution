class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        int len=s.length(),n=words.length;
        List<Integer> list=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(String str:words){
            map.put(str,map.getOrDefault(str,0)+1);
        }
        int one=words[0].length();
        for(int i=0;i<len;i++){
            Map<String,Integer> temp=new HashMap<>();
            int c=0;
            int j=i;
            while(c<n && i+one<=len){
                String str=s.substring(i,i+one);
                temp.put(str,temp.getOrDefault(str,0)+1);
                
                if(temp.get(str)>map.getOrDefault(str,0)) break;
                c++;
                i=i+one;
            }
            i=j;
            if(c==n) list.add(i);
        }
        return list;
    }
}