class Solution {
    public int minDistance(String word1, String word2) {
        
        int n=word1.length(),m=word2.length();
        return n + m-2*(longestCommonSubsequence(word1,word2));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n=text1.length(),m=text2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) dp[i][j]=text1.charAt(i)==text2.charAt(j)?1:0;
                else if(i==0) dp[i][j]=(text1.charAt(i)==text2.charAt(j))?1:dp[i][j-1];
                else if(j==0) dp[i][j]=(text1.charAt(i)==text2.charAt(j))?1:dp[i-1][j];
                else{
                    
                    dp[i][j]=(text1.charAt(i)==text2.charAt(j))?(dp[i-1][j-1]+1):Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n-1][m-1];
    }
}