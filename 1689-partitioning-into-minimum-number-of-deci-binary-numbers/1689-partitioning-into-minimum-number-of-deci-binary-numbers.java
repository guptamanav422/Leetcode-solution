class Solution {
    public int minPartitions(String n) {
        int max=1;
        for(char ch:n.toCharArray()){
            
            max=Math.max(max,ch-'0');
        }
        return max;
    }
}