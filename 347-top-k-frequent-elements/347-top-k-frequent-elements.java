class Solution {
    class pair implements Comparable<pair>{
        int num,fre;
        pair(int a,int b){
            num=a;
            fre=b;
        }
        
        public int compareTo(pair b){
            return this.fre-b.fre;
        }
    }
    public int[] topKFrequent(int[] nums, int k)
    {
        int n=nums.length;
        Queue<pair> pq=new PriorityQueue<>();
        Arrays.sort(nums);
        
        for(int i=0;i<n;i++){
            int count=1;
            while(i<n-1 && nums[i]==nums[i+1]){
                count++;
                i++;
            }
            pq.add(new pair(nums[i],count));
            
            if(pq.size()>k) pq.remove();
        }
        
        int ans[]=new int[k];
        int i=k-1;
        while(!pq.isEmpty()){
            ans[i--]=pq.remove().num;
        }
        return ans;
    }
}