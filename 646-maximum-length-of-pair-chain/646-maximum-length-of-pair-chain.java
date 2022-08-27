class Solution {
    public int findLongestChain(int[][] pairs)
    {
        Arrays.sort(pairs,new Comparator<>(){
            public int compare(int a[],int b[])
            {
                return a[0]-b[0];
            }
        });
        int n=pairs.length;
        int ans=1,prev=pairs[0][1];
        for(int i=1;i<n;i++)
        {
            if(pairs[i][0]>prev){
                ans++;
                prev=pairs[i][1];
            }
            else{
                prev=Math.min(prev,pairs[i][1]);
            }
        }
        return ans;
    }
}