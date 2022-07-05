class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int a:nums){
            set.add(a);
        }
        
        int ans=0;
        for(int a:nums){
            if(!set.contains(a-1)){
                
                int c=0;
                while(set.contains(a)) {
                    // set.remove(a++);
                    c++;
                    a++;
                }
                ans=Math.max(ans,c);
            }
        }
        return ans;
    }
}