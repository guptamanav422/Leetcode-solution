class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int a[]=new int[n];
        int b[]=new int[n];
        int c[]=new int[n];
        a[0]=-prices[0];
        for(int i=1;i<n;i++)
        {
            a[i]=Math.max(a[i-1],-prices[i]+c[i-1]);
            b[i]=Math.max(b[i-1],a[i]+prices[i]);
            c[i]=Math.max(b[i-1],c[i-1]);
        }
        return b[n-1];
    }
}