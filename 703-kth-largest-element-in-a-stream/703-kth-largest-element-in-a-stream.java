class KthLargest {
    PriorityQueue<Integer> q;
    int k;
    public KthLargest(int k, int[] nums) {
        q=new PriorityQueue<>();
        this.k=k;
        for(int a:nums){
            q.add(a);
            if(q.size()>k) q.remove();
        }
    }
    
    public int add(int a) {
        q.add(a);
        if(q.size()>k) q.remove();
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */