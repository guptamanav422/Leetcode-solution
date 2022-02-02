class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> ans=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((Integer a,Integer b)->((Math.abs(a-x)==Math.abs(b-x))?b-a:-(Math.abs(a-x)-Math.abs(b-x))));
        
        for(int a:arr){
            pq.add(a);
            
            if(pq.size()>k) pq.remove();
        }
        
        while(!pq.isEmpty()) ans.add(pq.remove());
        Collections.sort(ans);
        return ans;
    }
}