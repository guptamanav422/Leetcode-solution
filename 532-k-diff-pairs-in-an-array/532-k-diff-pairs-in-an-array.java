class Solution {
    public int findPairs(int[] nums, int k)
    {
        Map<Integer,Integer> map=new HashMap<>();
        for(int a:nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i])) continue;
            if(k==0){
                ans+=map.get(nums[i])==1?0:1;
                map.put(nums[i],map.get(nums[i])-1);
                map.remove(nums[i]);
            }
            else{
                if(map.containsKey(nums[i]-k)) ans++;
                if(map.containsKey(nums[i]+k)) ans++;
                // map.put(nums[i],map.get(nums[i])-1);
                map.remove(nums[i]);
            }
        }
        return ans;
    }
}