class Solution {
    public int getMaximumConsecutive(int[] coins) {
        
        Arrays.sort(coins);
        int r=0;
        for(int a:coins){
            if(r+1<a) return r+1;
            else r+=a;
        }
        return r+1;
    }
}