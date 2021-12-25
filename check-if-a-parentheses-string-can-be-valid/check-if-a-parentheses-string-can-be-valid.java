class Solution {
    public boolean canBeValid(String s, String locked) {
        
        int len=s.length();
        if(len%2!=0) return false;
        
        
        return check(s,')',locked) && check(new StringBuilder(s).reverse().toString(),'(',new StringBuilder(locked).reverse().toString());
    }
    boolean check(String s,char te,String locked){
        int ans=0,count=0;
        int len=s.length();
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            
            if(ch==te && locked.charAt(i)=='1') ans--;
            else ans++;
            
            if(ans<0) return false;
            if(locked.charAt(i)=='0') count++;
        }
        return (count>=(ans/2));
    }
}