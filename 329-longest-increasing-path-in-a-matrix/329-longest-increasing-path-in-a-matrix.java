class Solution {
    int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
    public int longestIncreasingPath(int[][] matrix)
    {
        int n=matrix.length;
        int m=matrix[0].length;
        int max=1;
        int ans[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(ans[i][j]==0){
                    find(matrix,ans,i,j,n,m,matrix[i][j]-1);
                    max=Math.max(max,ans[i][j]);
                }
            }
        }
        return max;
    }
    public int find(int arr[][],int ans[][],int i,int j,int n,int m,int prev){
        if(i<0 || j<0 || i==n || j==m || prev>=arr[i][j]) return 0;
        
        if(ans[i][j]!=0) return ans[i][j];
        int temp=0;
        for(int k=0;k<4;k++)
        {
            temp=Math.max(temp,find(arr,ans,i+dir[k][0],j+dir[k][1],n,m,arr[i][j]));
        }
        ans[i][j]=temp+1;
        return temp+1;
    }
    
}