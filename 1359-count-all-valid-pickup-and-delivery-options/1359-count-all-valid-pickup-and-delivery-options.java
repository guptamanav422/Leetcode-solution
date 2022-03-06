class Solution {
    public int countOrders(int n) {
        long ans=1,mod=1000000007;
        int s=(2*n-1);
        while(s!=1){
            ans=(ans*(s)*(s+1)/2)%mod;
            s-=2;
        }
        return (int)ans;
    }
}