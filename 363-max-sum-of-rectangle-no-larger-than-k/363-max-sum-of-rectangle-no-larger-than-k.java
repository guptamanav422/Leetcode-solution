class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k)
    {
        int n=matrix.length;
        int m=matrix[0].length;
        int max=(int)(-10*Math.pow(10,5));
        for(int c=0;c<n;c++)
        {
            int ans[]=new int[m];
            for(int i=c;i<n;i++)
            {
                int val=0;
                TreeSet<Integer> set=new TreeSet<>();
                set.add(0);
                for(int j=0;j<m;j++)
                {
                    ans[j]+=matrix[i][j];
                    val+=ans[j];
                    Integer num=set.ceiling(val-k);
                    if(num!=null){
                        max=Math.max(max,val-num);
                    }
                    set.add(val);
                }
            }
        }
        return max;
    }
}