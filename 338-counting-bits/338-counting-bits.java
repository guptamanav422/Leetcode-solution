class Solution {
    public int[] countBits(int n)
    {
        int arr[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            if(i%2!=0) arr[i]++;
            arr[i]+=arr[i/2];
        }
        return arr;
    }
}