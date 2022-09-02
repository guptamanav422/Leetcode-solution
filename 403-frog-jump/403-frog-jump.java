class Solution {
    public boolean canCross(int[] stones) {
        
        int n=stones.length;
        Map<Integer,Set<Integer>> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            map.put(stones[i],new HashSet<>());
        }
        map.get(0).add(1);
        for(int stone:stones){
            
            for(int step:map.get(stone)){
                
                int totalStep=stone+step;
                
                if(totalStep==stones[n-1]) return true;
                if(map.containsKey(totalStep)){
                    map.get(totalStep).add(step);
                    map.get(totalStep).add(step+1);
                    if(step!=1) map.get(totalStep).add(step-1);
                }
            }
        }
        return false;
    }
}