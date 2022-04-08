class Solution {
    public int minRefuelStops(int tar, int cur, int[][] stations) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0,res=0;
        for(res=0;cur<tar;res++){
            for(i=i;i<stations.length && stations[i][0]<=cur;i++){
                pq.add(-stations[i][1]);
            }
            if(pq.isEmpty()) return -1;
            cur+=-pq.remove();
        }
        return res;
    }
}