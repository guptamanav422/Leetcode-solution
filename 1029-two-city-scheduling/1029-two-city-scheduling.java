class Solution {
    int ans=0;
    int dp[][];
    public int twoCitySchedCost(int[][] costs) {
        
        int n=costs.length;
        dp=new int[n/2+1][n/2+1];
        ans=Integer.MAX_VALUE;
        find(costs,0,0,n/2,0);
        return ans;
    }
    void find(int arr[][],int c1,int c2,int n,int sum){
        
        if(sum>ans) return;
        if(c1+c2==(2*n)){
            ans=Math.min(ans,sum);
            return;
        }
        if(dp[c1][c2]!=0 && dp[c1][c2]<=sum) return;
        dp[c1][c2]=sum;
        if(c1<n) find(arr,c1+1,c2,n,sum+arr[c1+c2][0]);
        if(c2<n) find(arr,c1,c2+1,n,sum+arr[c1+c2][1]);
    }
}