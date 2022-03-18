class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int c[]  = new int[60], res = 0;
        for (int t : time) {
            int num=(60-t)%60;
            if(num<0) num+=60;
            res += c[num];
            c[t % 60] += 1;
        }
        return res;
    }
}