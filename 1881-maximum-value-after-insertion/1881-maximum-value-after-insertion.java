class Solution {
    public String maxValue(String s, int x) {
        
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='-') continue;
            
            if(s.charAt(0)!='-'){
                if((s.charAt(i)-'0')<x){
                    return s.substring(0,i)+x+s.substring(i);
                }
            }
            else{
                if((s.charAt(i)-'0')>x){
                    return s.substring(0,i)+x+s.substring(i);
                }
            }
        }
        return s+x;
    }
}