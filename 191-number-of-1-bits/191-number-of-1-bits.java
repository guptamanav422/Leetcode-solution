public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n)
    {
        if(n==0) return 0;
        // System.out.println(n);
        return 1+hammingWeight(n&(n-1));
    }
}