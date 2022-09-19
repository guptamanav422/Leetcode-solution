class Solution {
    public boolean searchMatrix(int[][] a, int target)
    {
        int n=a.length,m=a[0].length;
        int i=0,j=m-1;
        
        while(i<n && j>=0){
            
            if(a[i][j]==target) return true;
            else if(a[i][j]<target) i++;
            else j--;
        }
        return false;
    }
}