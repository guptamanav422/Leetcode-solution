class Solution {
    public long sumScores(String s)
    {
        int n=s.length();
        int arr[]=new int[n];
        find(s,n,arr);
        long ans=n;
        for(int a:arr) {
            ans+=a;
        }
        return ans;
    }
    static long find(String str, int n, int z[])
    {
        int l=0,r=0;
        long ans=n;
        for(int k=1;k<n;k++){
            if(k>r){
                l=r=k;
                
                while(r<n && str.charAt(r)==str.charAt(r-l)) r++;
                
                z[k]=r-l;
                r--;
            }
            else{
                int k1=k-l;
                if(z[k1]<r-k+1){
                    z[k]=z[k1];
                } 
                else{
                    l=k;
                    while(r<n && str.charAt(r)==str.charAt(r-l)) r++;
                    z[k]=r-l;
                    r--;
                }
            }
            ans+=z[k];
        }
        return ans;
    }
 
}