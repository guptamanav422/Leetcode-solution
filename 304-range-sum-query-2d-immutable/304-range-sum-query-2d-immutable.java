class NumMatrix {

    int arr[][];
    public NumMatrix(int[][] mat) {
        int n=mat.length,m=mat[0].length;
        for(int i=0;i<n;i++){
            for(int j=(i==0?1:0);j<m;j++){
                if(i==0 || j==0){
                    mat[i][j]+=i==0?mat[i][j-1]:mat[i-1][j];
                }
                else{
                    mat[i][j]+=mat[i-1][j]+mat[i][j-1]-mat[i-1][j-1];
                }
            }
        }
        arr=mat;
    }
    
    public int sumRegion(int i1, int j1, int i2, int j2)
    {
        return arr[i2][j2]-(i1==0?0:arr[i1-1][j2]) - (j1==0?0:arr[i2][j1-1]) + ((i1==0 || j1==0)?0:arr[i1-1][j1-1]);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */