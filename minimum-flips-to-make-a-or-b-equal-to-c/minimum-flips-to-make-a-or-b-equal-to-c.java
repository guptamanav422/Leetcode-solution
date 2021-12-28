class Solution {
    public int minFlips(int a, int b, int c) {
        
        int ans=0;
        while(c!=0 || a!=0 || b!=0){
            
            int c1=c%2,a1=a%2,b1=b%2;
            
            c=c/2;
            a=a/2;
            b=b/2;
            
            if(c1==1){
                if(a1!=1 && b1!=1) ans++; 
            }
            else{
                if(a1==1) ans++;
                if(b1==1) ans++;
            }
        }
        return ans;
    }
}