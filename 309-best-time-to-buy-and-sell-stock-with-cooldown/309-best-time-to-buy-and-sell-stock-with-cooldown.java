class Solution {
    
    int dp[];
    public int maxProfit(int[] prices) {
        
        int n=prices.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        find(prices,0);
        for(int a:dp){
            System.out.print(a+" ");
        }
        return dp[0];
    }
    
    int find(int arr[],int i){
        
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        
        dp[i]=find(arr,i+1);
        int min=arr[i];
        // System.out.println("hello");
        for(int j=i+1;j<arr.length;j++){
            min=Math.min(min,arr[j]);
            
            dp[i]=Math.max(dp[i],arr[j]-min+find(arr,j+2));
            }
        return dp[i];
    }
}