class Solution
{
    int ld[],rd[],y[];
    int count=0;
    public int totalNQueens(int n)
    {
        count=0;
        ld=new int[2*n];
        rd=new int[2*n];
        y=new int[n];
        find(0,n);
        return count;
    }
    void find(int i,int n)
    {
        if(i==n){
            count++;
            return;
        }
        
        for(int j=0;j<n;j++)
        {
            if(ld[i+j]==0 && rd[n-i-1+j]==0 && y[j]==0)
            {
                ld[i+j]=rd[n-1-i+j]=y[j]=1;
                find(i+1,n);
                ld[i+j]=rd[n-1-i+j]=y[j]=0;
            }
        }
    }
}