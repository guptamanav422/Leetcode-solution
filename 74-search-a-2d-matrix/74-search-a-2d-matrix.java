class Solution {
    public boolean searchMatrix(int[][] a, int target)
    {
         if (a == null || a.length == 0)
                return false;
        int i=0,n=a.length,m=a[0].length;
        int last=n*m-1;
        while(i<=last)
        {
            int mid=(i+last)/2;
            if(a[mid/m][mid%m]>target)
                last=mid-1;
            else if(a[mid/m][mid%m]<target)
                i=mid+1;
            else return true;
        }
        return false;
    }
}