class Solution {
    public boolean isStrictlyPalindromic(int n) {
        
        
        boolean ok=true;
        int num=n;
        for(int i=2;i<=(num-2);i++){
            
            String str="";
            n=num;
            while(n>0){
                str+=n%i;
                n/=i;
            }
            // System.out.println(str);
            if(!str.equals(new StringBuilder(str).reverse().toString())){
                ok=false;
                break;
            }
        }
        return ok;
    }
}