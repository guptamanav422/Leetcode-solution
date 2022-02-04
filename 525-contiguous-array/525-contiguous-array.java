class Solution {
    public int findMaxLength(int[] nums) {
        
        Map<Integer,Integer> map=new HashMap<>();
        int c=0,ans=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) c++;
            else c--;
            
            ans=Math.max(ans,i-map.getOrDefault(c,i));
            if(!map.containsKey(c)) map.put(c,i);
        }
        return ans;
    }
}