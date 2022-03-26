class Solution {
    public int countDigitOne(int n) {
        int res = 0;
        for (long i = 1; i <= n; i *= 10) {
            int prefix = (int)(n/(i*10));
            int digit = (int)((n/i)%10); 
            int suffix = (int)(n%i);
            if (digit == 0) {
                res += prefix*i;
            } else if (digit == 1) {
                res += prefix*i + suffix + 1;
            } else {
                res += (prefix + 1)*i;
            }
        }
        return res;
    }
}