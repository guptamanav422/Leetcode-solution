class Solution {
    public boolean checkSubarraySum(int[] nums, int k)
    {
        Map<Integer,Integer> map=new HashMap<>();
        int sum=0;
        map.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            sum=(sum+nums[i]%k)%k;
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            else if(i-map.get(sum)>1) return true;
        }
        return false;
    }
}