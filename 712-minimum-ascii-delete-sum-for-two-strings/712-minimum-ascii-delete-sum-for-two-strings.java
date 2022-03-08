class Solution {
    public int minimumDeleteSum(String text1, String text2) {
        
        int n=text1.length(),m=text2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) dp[i][j]=text1.charAt(i)==text2.charAt(j)?text1.charAt(i):0;
                else if(i==0) dp[i][j]=(text1.charAt(i)==text2.charAt(j))?text1.charAt(i):dp[i][j-1];
                else if(j==0) dp[i][j]=(text1.charAt(i)==text2.charAt(j))?text1.charAt(i):dp[i-1][j];
                else{
                    
                    dp[i][j]=(text1.charAt(i)==text2.charAt(j))?(text1.charAt(i)+dp[i-1][j-1]):Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=text1.charAt(i);
        }
        for(int i=0;i<m;i++){
            sum+=text2.charAt(i);
        }
        return sum-2*(dp[n-1][m-1]);
    }
}