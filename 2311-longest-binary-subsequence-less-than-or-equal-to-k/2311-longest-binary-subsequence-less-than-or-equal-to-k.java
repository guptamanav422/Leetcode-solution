class Solution {
    public int longestSubsequence(String s, int kk) {
        
        int c=0,n=s.length();
        for(char ch:s.toCharArray()){
            if(ch=='0') c++;
        }
        long k=kk;
        
        long num=1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                k-=num;
                
                if(k<0) break;
                c++;
            }
            
            num*=2;
            if(num>Integer.MAX_VALUE) break;
        }
        return c;
    }
}