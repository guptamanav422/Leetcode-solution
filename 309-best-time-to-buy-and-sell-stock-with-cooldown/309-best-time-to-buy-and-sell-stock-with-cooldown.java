class Solution {
    public int maxProfit(int[] prices) {
        int sold = 0, hold = -prices[0], rest = 0;
        for(int i=1;i<prices.length;i++){
            
            int prevSold=sold;
            hold=Math.max(hold,rest-prices[i]);
            sold=Math.max(sold,hold+prices[i]);
            
            rest=Math.max(prevSold,rest);
        }
        return sold;
    }
}


