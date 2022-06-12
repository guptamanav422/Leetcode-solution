class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        int n=nums.length;
        int pre[]=new int[n];
        Map<Integer,Integer> map=new HashMap<>();
        int st=-1,ans=0;
        for(int i=0;i<n;i++){
            
            pre[i]=nums[i];
            if(i!=0) pre[i]+=pre[i-1];
        }
        for(int i=0;i<n;i++){
            st=Math.max(st,map.getOrDefault(nums[i],-1));
            ans=Math.max(ans,pre[i]-(st==-1?0:pre[st]));
            map.put(nums[i],i);
        }
        return ans;
    }
}