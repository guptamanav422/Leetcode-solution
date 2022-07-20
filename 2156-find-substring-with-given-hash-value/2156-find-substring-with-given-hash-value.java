class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        
        
        long num=1;
        for(int i=0;i<k;i++){
            num=(num*power)%modulo;
        }
        
        int ans=0,n=s.length();
        long val=0;
        for(int i=n-1;i>=(n-k);i--){
            val=((val*power)%modulo + (s.charAt(i)-'a'+1))%modulo;
        }
        // System.out.println(val);
        
        if(val==hashValue) ans=n-1;
        
        for(int i=s.length()-2;i>=(k-1);i--){
            int j=i-k+1;
            val=((val*power) + (s.charAt(j)-'a'+1) -((s.charAt(i+1)-'a'+1)*num))%modulo;
            val=(val+modulo)%modulo;
            
            if(val==hashValue) ans=i;
        }
        return s.substring(ans-k+1,ans+1);
    }
}