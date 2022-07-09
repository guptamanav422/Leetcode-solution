class Solution {
    public int maxResult(int[] nums, int k) {
        
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            
            while(!q.isEmpty() && (i-q.peek())>k) q.remove();
            // if(i==4){
            //     System.out.println(q.peek());
            // }
            nums[i]+=(q.isEmpty())?0:(nums[q.peek()]);            
            while(!q.isEmpty() && nums[i]>nums[q.peekLast()]) q.removeLast();
            // System.out.print(nums[i]+" ");
            q.add(i);
        }
        return nums[nums.length-1];
    }
}