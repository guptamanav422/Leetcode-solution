class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int max=0;
        for(int a[]:accounts){
            int temp=0;
            for(int j:a){
                temp+=j;
            }
            max=Math.max(max,temp);
        }
        return max;
    }
}