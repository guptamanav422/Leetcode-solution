class Solution {
    public int nextGreaterElement(int n) {
        StringBuilder sb=new StringBuilder(n+"");
        
        int len=sb.length(),i=len-1;
        for(;i>0;i--){
            if(sb.charAt(i)<=sb.charAt(i-1)) continue;
            else break;
        }
        if(i==0) return -1;
        i--;
        for(int j=len-1;j>i;j--){
            if(sb.charAt(j)>sb.charAt(i)){
                
                char ch1=sb.charAt(i);
                char ch2=sb.charAt(j);
                
                sb.setCharAt(j,ch1);
                sb.setCharAt(i,ch2);
                break;
            }
        }
        
        String s=(sb.substring(0,i+1)+(new StringBuilder(sb.substring(i+1)).reverse()).toString());
        // System.out.println(s);
        Long temp=Long.parseLong(s);
        
        if(temp>Integer.MAX_VALUE) return -1;
        return Integer.parseInt(s);
    }
}