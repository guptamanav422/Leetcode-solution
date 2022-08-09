class Solution {
     public int Cyclic(int[] nums,int s,int e) {
        
        int prev=0,prev1=0;
        for(int i=s;i<=e;i++){
            int a=nums[i];
            int b=Math.max(prev,prev1+a);
            
            prev1=prev;
            prev=b;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        return Math.max(Cyclic(nums,0,n-2),Cyclic(nums,1,n-1));
    }
}