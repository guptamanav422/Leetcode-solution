class Solution {
    String ss;
    int dp[][];
    public int longestPalindromeSubseq(String s1)
    {
        dp=new int[s1.length()][s1.length()];
        ss=s1;
        return find(0,s1.length()-1);
    }
    int find(int i,int j){
        
        if(i>j) return 0;
        if(i==j) return 1;
        
        if(dp[i][j]!=0) return dp[i][j];
        if(ss.charAt(i)==ss.charAt(j)) return dp[i][j]=find(i+1,j-1)+2;
        return dp[i][j]=Math.max(find(i+1,j),find(i,j-1));
    }
}