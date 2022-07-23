class Solution {
    public int minSteps(int n) {
        
        int dp[][]=new int[n+1][n+1];
        return find(1,0,n,dp);
    }
    int find(int i,int t,int n,int dp[][]){
        if(i==n) return 0;
        if(i>n) return Integer.MAX_VALUE;
        
        if(dp[i][t]!=0) return dp[i][t];
        
        int num1=(t==0)?Integer.MAX_VALUE:find(i+t,t,n,dp);
        int num2=find(i+i,i,n,dp);
        
        if(num1!=Integer.MAX_VALUE) num1+=1;
        if(num2!=Integer.MAX_VALUE) num2+=2;
        
        return dp[i][t]=Math.min(num1,num2);
    }
}