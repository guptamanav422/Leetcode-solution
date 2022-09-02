class Solution {
    public int[][] insert(int[][] intervals, int[] next) {
        
        List<int []> list=new ArrayList<>();
        
        for(int interval[]:intervals){
            
            if(interval[1]<next[0]){
                list.add(interval);
            }
            else if(next[1]<interval[0]){
                list.add(next);
                next=interval;
            }
            else{
                next[0]=Math.min(next[0],interval[0]);
                next[1]=Math.max(next[1],interval[1]);
            }
        }
        list.add(next);
        return list.toArray(new int[list.size()][]);
    }
}