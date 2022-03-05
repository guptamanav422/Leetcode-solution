class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int a:nums){
            max=Math.max(max,a);
        }
        
        int hash[]=new int[max+1];
        for(int a:nums){
            hash[a]++;
        }
        
        for(int i=2;i<=max;i++){
            hash[i]=Math.max(i*hash[i]+hash[i-2],hash[i-1]);
        }
        return hash[max];
    }
}