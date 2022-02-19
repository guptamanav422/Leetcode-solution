class Solution {
    public int minimumDeviation(int[] nums) {
        
        int n=nums.length;
        Queue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]%2!=0) nums[i]*=2;
            pq.add(nums[i]);
            min=Math.min(min,nums[i]);
        }
        int ans=Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            int num=pq.remove();
            ans=Math.min(ans,Math.abs(num-min));
            if(num%2==0) pq.add(num/2);
            else break;
            
            min=Math.min(min,num/2);
        }
        return ans;
    }
}