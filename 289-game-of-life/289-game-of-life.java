class Solution {
    int dir[][]={{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};
    int r,c;
    public void gameOfLife(int[][] board)
    {
        r=board.length;
        c=board[0].length;
        find(board,0,0);
    }
    void find(int arr[][],int i,int j)
    {
        if(i==r) return;
        
        int one=0,zero=0;
        for(int k=0;k<dir.length;k++)
        {
            int x=i+dir[k][0];
            int y=j+dir[k][1];
            if(x<0 || y<0 || x==r || y==c) continue;
            if(arr[x][y]==1) one++;
            else zero++;
        }
        
        if(j==c-1) find(arr,i+1,0);
        else find(arr,i,j+1);
        
        if(arr[i][j]==0 && one==3) arr[i][j]=1;
        else if(arr[i][j]==1 && (one<2 || one>3)) arr[i][j]=0;
    }
}