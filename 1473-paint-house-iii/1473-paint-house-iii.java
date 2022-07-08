class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int dp[][][]=new int[m][n+1][target+1];
        
        int ans=find(houses,cost,0,0,0,target,dp);
        
        return (ans==Integer.MAX_VALUE)?-1:ans;
    }
    
    int find(int h[],int cost[][],int i,int t,int p,int target,int dp[][][]){
        
        if(t>target || (h.length-i)<(target-t)) return Integer.MAX_VALUE;
        if(i==h.length && t==target) return 0;
        
        if(dp[i][p][t]!=0) return dp[i][p][t];
        
        if(h[i]!=0){
            return dp[i][p][t]=find(h,cost,i+1,(i!=0 && p==(h[i]-1))?t:(t+1),h[i]-1,target,dp);
        }
        else{
            int num=Integer.MAX_VALUE;
            for(int j=0;j<cost[0].length;j++){
               h[i]=j+1;
               int temp=find(h,cost,i+1,(p==j && i!=0)?t:t+1,j,target,dp);
               num=Math.min(num,(temp==Integer.MAX_VALUE)?temp:temp+cost[i][j]);
               h[i]=0;
            }
            return dp[i][p][t]=num;
        }
    }
}