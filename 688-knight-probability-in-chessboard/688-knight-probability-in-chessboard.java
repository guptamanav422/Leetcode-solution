class Solution {
    int dir[][]={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
    double dp[][][];
    public double knightProbability(int n, int k, int row, int column) {
        
        dp=new double[n][n][k+1];
        return find(row,column,n,k);
    }
    double find(int r,int c,int n,int k){
        
        double ans=0;
        if(k==0) return 1.0;
        if(dp[r][c][k]!=0.0d) return dp[r][c][k];
        for(int arr[]:dir){
            
            int r1=r+arr[0],c1=c+arr[1];
            
            if(r1<0 || c1<0 || r1>=n || c1>=n) continue;
            
            ans+=find(r1,c1,n,k-1)/8;
        }
        return dp[r][c][k]=ans;
    }
}