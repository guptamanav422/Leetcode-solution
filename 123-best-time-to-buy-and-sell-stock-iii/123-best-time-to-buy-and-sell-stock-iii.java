class Solution {
    public int maxProfit(int[] prices) {
        
        
        int cost1=Integer.MAX_VALUE,profit=0,cost2=Integer.MAX_VALUE,profit2=0;
        
        for(int a:prices){
            
            cost1=Math.min(cost1,a);
            profit=Math.max(profit,a-cost1);
            
            cost2=Math.min(cost2,a-profit);
           profit2=Math.max(profit2,a-cost2);
        }
        return profit2;
    }
}

