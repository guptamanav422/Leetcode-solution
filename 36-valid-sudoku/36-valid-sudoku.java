class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean row[][]=new boolean[9][10],col[][]=new boolean[9][10],box[][]=new boolean[9][10];
        
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                
                int a=board[i][j]-'0';
                if(row[i][a] || col[j][a] || box[i-i%3+j/3][a]) return false;
                row[i][a] =col[j][a] = box[i-i%3+j/3][a]=true;
            }
        }
        return true;
    }
}