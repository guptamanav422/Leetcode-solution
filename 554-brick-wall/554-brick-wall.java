class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> map=new HashMap<>();
        
        int max=0;
        for(List<Integer> list:wall){
            int prev=0;
            for(int a:list){
                if(prev!=0){
                    map.put(prev,map.getOrDefault(prev,0)+1);
                    max=Math.max(max,map.get(prev));
                }
                prev+=a;
            }
        }
        return wall.size()-max;
    }
}