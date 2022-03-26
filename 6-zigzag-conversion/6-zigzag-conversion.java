class Solution {
    public String convert(String s, int num) {
        
        if(num==1) return s;
        StringBuilder sb=new StringBuilder();
        
        int len=s.length();
        for(int i=0;i<num;i++){
            
            int n=(num-i-1)*2==0?(num-1)*2:(num-i-1)*2;
            int c=0;
            for(int j=i;j<len;j+=n){
                sb.append(s.charAt(j));
                
                c++;
                if(c%2==0 && i!=0) j+=(i)*2-n;
            }
        }
        return sb.toString();
    }
}