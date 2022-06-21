class Solution {
    public int furthestBuilding(int[] arr, int bricks, int ladders) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int n=arr.length;
        int ans=0;
        for(int i=1;i<n;i++){
            
            int diff=(arr[i]-arr[i-1]);
            if(diff>0){
                pq.add(diff);
                bricks-=diff;
                while(bricks<0 && ladders>0 && !pq.isEmpty()){
                    bricks+=(pq.remove());
                    ladders--;
                }

                if(bricks<0) break;
            }
            ans=i;
        }
        return ans;
        
    }
}