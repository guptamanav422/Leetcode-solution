class Solution {
    public int removeBoxes(int[] boxes) {
        
        int n=boxes.length;
        int dp[][][]=new int[n][n][n];
        return find(boxes,0,n-1,0,dp);
    }
    int find(int arr[],int i,int j,int k,int dp[][][]){
        if(i>j) return 0;
        if(dp[i][j][k]!=0) return dp[i][j][k];
        
        
        int ii=i;
        while(ii<j && arr[ii]==arr[ii+1]) ii++;
        
        int res=(k+ii-i+1)*(k+ii-i+1)+ find(arr,ii+1,j,0,dp);
        
        for(int idx=i+1;idx<=j;idx++){
            if(arr[idx]==arr[i]){
                res=Math.max(res,find(arr,i+1,idx-1,0,dp)+find(arr,idx,j,k+1,dp));
            }
        }
        return dp[i][j][k]=res;
    }
}