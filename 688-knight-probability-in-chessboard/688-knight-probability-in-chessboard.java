class Solution {
    
    int dir[][]={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
    
    double dp[][][];
    public double knightProbability(int n, int k, int row, int column) {
        
        dp=new double[n][n][k+1];
        return find(n,k,row,column);
    }
    double find(int n,int k,int row,int column){
        if(row<0 || column<0 || row>=n || column>=n) return 0.0;
        if(k==0) return 1.0;
        
        if(dp[row][column][k]!=0.0d) return dp[row][column][k];
        System.out.println(dp[row][column][k]);
        double ans=0.0;
        for(int i=0;i<8;i++){
            ans+=((double)(find(n,k-1,row+dir[i][0],column+dir[i][1])))/(double)8.0;
        }
        
        return dp[row][column][k]=ans;
    }
}