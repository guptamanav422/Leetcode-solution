class Solution {
    public String shortestPalindrome(String s) {
        
        String str=s+reverse(s);
        
        int n=str.length();
        if(n==0) return "";
        int arr[]=new int[n];
        int len=0;
        for(int i=1;i<n;){
            if(i==n/2) len=0;
            if(str.charAt(i)==str.charAt(len)){
                len++;
                arr[i]=len;
                i++;
            }
            else{
                if(len!=0) len=arr[len-1];
                else i++;
            }
        }
        // for(int i=0;i<n;i++)
        return reverse(s.substring(arr[n-1]))+s;
    }
    String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
}