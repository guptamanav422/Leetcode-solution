class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        
        String s=countAndSay(n-1);
        StringBuilder sb=new StringBuilder();
        
        int len=s.length();
        for(int i=0;i<len;i++){
            
            int c=0,j=i;
            while(j<len-1 && s.charAt(j)==s.charAt(j+1)) j++;
            sb.append((j-i+1)+""+s.charAt(j));
            i=j;
        }
        // System.out.println(n+"  "+sb.toString());
        return sb.toString();
    }
}