class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        
        int n=s1.length(),m=s2.length(),l=s3.length();
        if(n+m!=l) return false;
        
        
        boolean dp[][]=new boolean[n+1][m+1];
        return find(s1,s2,s3,0,0,0,dp);
    }
    boolean find(String s1,String s2,String s3,int i,int j,int k,boolean dp[][]){
        
        // System.out.println(i+" "+j+" "+k);
        if(k==s3.length()) return true;
        
        if(dp[i][j]) return false;
        if(i!=s1.length() && s1.charAt(i)==s3.charAt(k) && find(s1,s2,s3,i+1,j,k+1,dp)) return true;
        if(j!=s2.length() && s2.charAt(j)==s3.charAt(k) && find(s1,s2,s3,i,j+1,k+1,dp)) return true;
        
        dp[i][j]=true;
        return false;
    }
}