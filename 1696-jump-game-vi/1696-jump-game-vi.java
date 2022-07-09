class Solution {
    public int maxResult(int[] nums, int k) {
        
        PriorityQueue<int []> pq=new PriorityQueue<>((int a[],int b[])->(b[1]-a[1]));
        
        pq.add(new int[]{0,nums[0]});
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            
            while((i-pq.peek()[0])>k) pq.remove();
            ans=nums[i]+pq.peek()[1];
            pq.add(new int[]{i,ans});
        }
        return ans;
    }
}