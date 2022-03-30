class Solution {
    boolean hor[][]=new boolean[9][10],ver[][]=new boolean[9][10];
    boolean box[][]=new boolean[9][10];
    public void solveSudoku(char[][] board) {
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                
                if(board[i][j]=='.') continue;
                
                int num=board[i][j]-'0';
                
                int idx=(i-i%3) + (j/3);
                hor[i][num]=ver[j][num]=box[idx][num]=true;
            }
        }
        find(board,0);
    }
    boolean find(char arr[][],int idx){
        if(idx==81) return true;
        
        int i=idx/9,j=idx%9;
        
        if(arr[i][j]!='.') return find(arr,idx+1);
        
        for(int ii=1;ii<=9;ii++){
            if(hor[i][ii] || ver[j][ii] || box[i-i%3 + j/3][ii]) continue;
            
            hor[i][ii] = ver[j][ii] = box[i-i%3 + j/3][ii]=true;
            arr[i][j]=(char)('0'+ii);
            if(find(arr,idx+1)) return true;
            hor[i][ii] = ver[j][ii] = box[i-i%3 + j/3][ii]=false;
            arr[i][j]='.';
        }
        return false;
    }
}