class Solution {
    public int[][] generateMatrix(int n) {
        
        int arr[][]=new int[n][n];
        int num=1;
        int rs=0,re=n-1,cs=0,ce=n-1;
        
        while(rs<=re || cs<=ce){
            
            for(int i=cs;i<=ce;i++){
                arr[rs][i]=num++;
            }
            rs++;
            
            for(int i=rs;i<=re;i++){
                arr[i][ce]=num++;
            }
            ce--;
            
            for(int i=ce;i>=cs;i--){
                arr[re][i]=num++;
            }
            
            re--;
            
            for(int i=re;i>=rs;i--){
                arr[i][cs]=num++;
            }
            cs++;
        }
        return arr;
    }
}