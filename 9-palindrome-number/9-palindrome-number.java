class Solution {
    int y;
    public boolean isPalindrome(int x) {
       y=x;
        if(x<0) return false;
       return check(x);
    }
    boolean check(int x){
        
        if(x==0) return true;
        
        boolean ans=check(x/10);
        
        boolean ans1=x%10==y%10;
        y/=10;
        return ans & ans1;
        
    }
}