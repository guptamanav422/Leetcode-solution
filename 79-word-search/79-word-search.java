class Solution {
    int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        
        int n=board.length,m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0)==board[i][j] && check(i,j,0,board,word)) return true;
            }
        }
        return false;
    }
    boolean check(int r,int c,int i,char board[][],String str){
        if(r<0 || r==board.length || c<0 || c==board[0].length || str.charAt(i)!=board[r][c]) return false;
        
        if(i==str.length()-1) return true;
        board[r][c]='.';
        for(int k=0;k<4;k++){
            if(check(r+dir[k][0],c+dir[k][1],i+1,board,str)) return true;
        }
        board[r][c]=str.charAt(i);
        return false;
    }
}