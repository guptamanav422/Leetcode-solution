class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        
        long num=0,temp=1;
        for(int i=1;i<k;i++){
            temp=(temp*power)%modulo;
        }
        int n=s.length();
        for(int i=n-1;i>=n-k;i--){
            num=(num*power+(s.charAt(i)-'a'+1))%modulo;
        }
        int st=-1;
        if(num==hashValue) st=n-k;
        // System.out.print(num+" ");
        for(int i=n-k-1;i>=0;i--){
            
            num=(((num-((s.charAt(i+k)-'a'+1)*temp)%modulo)*power)%modulo + (s.charAt(i)-'a'+1))%modulo;
            if(num<0) num+=modulo;
            // System.out.print(num+" ");
            if(num==hashValue) st=i;
        }
        return s.substring(st,st+k);
    }
}