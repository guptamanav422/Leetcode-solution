class Solution {
    public String getSmallestString(int n, int k) {
        
        
        StringBuffer sb=new StringBuffer();
        for(int i=1;i<=n;i++){
            
            if((n-i)*26>=k){
                k--;
                sb.append("a");
            }
            else {
                
                sb.append((char)('a'+k-(n-i)*26-1));
                k=(n-i)*26;
            }
        }
        return sb.toString();
    }
}