class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        TreeMap<String, Integer>[] buckets = new TreeMap[words.length];
        for(Map.Entry<String, Integer> e:map.entrySet()){
            String word = e.getKey();
            int freq = e.getValue();
            if(buckets[freq]==null){
                buckets[freq] = new TreeMap<>((a, b)->{
                    return a.compareTo(b);
                });
            }
            buckets[freq].put(word, freq);
        }
        
        List<String> ans = new LinkedList<>();
        for(int i = buckets.length-1;i>=0;i--){
            if(buckets[i]!=null){
                TreeMap<String, Integer> temp = buckets[i];
                if(temp.size()<k){
                    k = k - temp.size();
                    while(temp.size()>0){
                        ans.add(temp.pollFirstEntry().getKey());
                    }  
                }
                else {
                    while(k>0){
                        ans.add(temp.pollFirstEntry().getKey());
                        k--;
                    }
                    break;
                }
            }
        }     
        return ans;
    }
}