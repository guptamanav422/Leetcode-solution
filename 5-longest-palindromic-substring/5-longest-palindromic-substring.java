class Solution {
    public String longestPalindrome(String s) {
        
        int n=s.length();
        boolean arr[][]=new boolean[n][n];
        
        String ans=""+s.charAt(0);
        if(n==1) return ans;
        for(int i=0;i<n;i++){
            arr[i][i]=true;
            if(i!=n-1){
                
                arr[i][i+1]=(s.charAt(i)==s.charAt(i+1));
                
                if(arr[i][i+1]) ans=s.substring(i,i+2);
            }
        }
        
        for(int g=2;g<n;g++){
            for(int i=0,j=g;j<n;j++,i++){
                
                arr[i][j]=(s.charAt(i)==s.charAt(j)) && arr[i+1][j-1];
                
                if(arr[i][j]) ans=s.substring(i,j+1);
            }
        }
        return ans;
    }
}