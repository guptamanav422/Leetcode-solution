class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        for(int a:stones){
            q.add(a);
        }
        while(q.size()>1){
            
            int a=q.remove();
            int b=q.remove();
            if(a!=b) q.add(Math.abs(a-b));
        }
        return q.isEmpty()?0:q.remove();
    }
}