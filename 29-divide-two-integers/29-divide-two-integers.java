class Solution {
    public int divide(int dividend, int divisor)
    {
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        int sign=(dividend<0)^(divisor<0)?-1:1;
        
        int ans=0;
        dividend=Math.abs(dividend);
        divisor=Math.abs(divisor);
        while(dividend-divisor>=0){
            int x=0;
            for(x=0;dividend-(divisor<<x<<1)>=0;x++);
            ans+=1<<x;
            dividend-=divisor<<x;
        }
        return ans*sign;
    }
}