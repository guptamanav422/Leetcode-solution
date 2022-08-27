class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0, hold = -prices[0], rest = 0;
        for (int i=1; i<prices.length; ++i)
        {
            int prvSold = sold;
            sold = hold + prices[i];
            hold = Math.max(hold, rest-prices[i]);
            rest = Math.max(rest, prvSold);
        }
        return Math.max(sold, rest);
    }
}

