class Solution {
    public int minDistance(String word1, String word2) {
        
        int n=word1.length(),m=word2.length();
        
        if(n==0 || m==0) return Math.max(n,m);
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) dp[i][j]=word1.charAt(i)==word2.charAt(j)?0:1;
                else if(i==0) dp[i][j]=(word1.charAt(i)==word2.charAt(j))?j:dp[i][j-1]+1;
                else if(j==0) dp[i][j]=(word1.charAt(i)==word2.charAt(j))?i:dp[i-1][j]+1;
                else dp[i][j]=(word1.charAt(i)==word2.charAt(j))?dp[i-1][j-1]:(1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])));
            }
        }
        return dp[n-1][m-1];
    }
}