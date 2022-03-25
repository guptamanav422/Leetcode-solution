class Solution {
    public String longestPrefix(String s) {
        int n=s.length();
        int arr[]=new int[n];
        int len=0;
        for(int i=1;i<n;){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                arr[i]=len;
                i++;
            }
            else{
                if(len!=0) len=arr[len-1];
                else i++;
            }
        }
        return s.substring(0,arr[n-1]);
    }
}