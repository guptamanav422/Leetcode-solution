class Solution {
    public int brokenCalc(int s, int e) {
        int ans=0;
        while(e>s){
            
            if(e%2!=0) e=e+1;
            else e=e/2;
            ans++;
        }
        return s-e+ans;
    }
}