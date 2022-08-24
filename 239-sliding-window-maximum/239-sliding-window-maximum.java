class Solution {
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        Deque<Integer> q=new ArrayDeque<>();
        int n=nums.length;
        int ans[]=new int[n-k+1];
        for(int i=0;i<n;i++)
        {
            while(!q.isEmpty() && nums[q.peekFirst()]<=nums[i]) q.pollFirst();
            if(!q.isEmpty() && q.peekLast()<=i-k) q.pollLast();
            
            q.push(i);
            if(i>=(k-1)) ans[i-(k-1)]=nums[q.peekLast()];
        }
        return ans;
    }
}