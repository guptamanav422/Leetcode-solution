class Solution {
    public int subarraySum(int[] nums, int k)
    {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0,ans=0;
        map.put(0,1);
        for(int a:nums)
        {
            sum+=a;
            ans+=map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}