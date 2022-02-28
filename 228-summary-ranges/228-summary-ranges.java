class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int s=nums[0],j=i;
            while(j<nums.length && (i==j || (nums[j-1]+1)==nums[j])){
                j++;
            }
            
            j--;
            if(i!=j) ans.add(nums[i]+"->"+(nums[j]));
            else ans.add(nums[i]+"");
            
            i=j;
        }
        return ans;
    }
}