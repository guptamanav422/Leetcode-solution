class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int n=nums.length;
        long pre[]=new long[n];
        for(int i=1;i<n;i++){
            
            int j=n-1-i;
            pre[i]+=pre[i-1]+(nums[i]-nums[i-1])*i;
            pre[j]+=pre[j+1]+(nums[j+1]-nums[j])*i;
        }
        long min=Integer.MAX_VALUE;
        for(long a:pre){
            min=Math.min(min,a);
        }
        return (int) min;
    }
}