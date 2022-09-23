class Solution {
    public int concatenatedBinary(int n) {
        
        long num=0,mod=1000000007;
        for(int i=1;i<=n;i++){
            
            long a=i;
            while(a!=0){
                num=(num*2)%mod;
                a/=2;
            }
            num=(num+i)%mod;
            // System.out.println(num);
        }
        return (int) num;
    }
}