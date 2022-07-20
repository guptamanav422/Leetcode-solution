class Solution {
    public long minimalKSum(int[] nums, int k) {
        long ans=0;
        Arrays.sort(nums);
        int n=nums.length;
        long prev=0;
        // for(int a:nums){
        //     System.out.print(a+" ");
        // }
        // System.out.println();
        for(int i=0;i<=n && k>0;i++){
            long next;
            if(i==n){
                next=prev+k+1;
            }
            else next=Math.min(prev+k+1,nums[i]);
            if(next==prev) continue;
            
            ans+=((next)*(next-1))/2 - ((prev+1)*(prev))/2;
            // System.out.println(ans);
            k-=(next-1-prev);
            // System.out.println(prev+" "+next+" "+ans);
            if(i!=n) prev=nums[i];
        }
        return ans;
    }
}