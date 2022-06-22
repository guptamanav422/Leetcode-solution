class Solution {
public:
    string lcs(string s){
        int n=s.size();
        vector<vector<int>>dp(n+1,vector<int>(n+1,0));
        
        for(int i=1;i<=n;i++) dp[i][i]=1;
        string ans=s.substr(0,1);
        for(int i=1;i<n;i++){
            if(s[i-1]==s[i]){
                ans=s.substr(i-1,2);
                dp[i][i+1]=1;
            }
        }
        for(int g=2;g<n;g++)
            for(int i=1,j=i+g;j<=n;j++,i++)
                if(s[i-1]==s[j-1] && dp[i+1][j-1]){
                    dp[i][j]=1;
                    
                    if(ans.length()<(j-i+1)) ans=s.substr(i-1,(j-i+1));
                }
                else
                    dp[i][j]=0;
        
        return ans;
    }
    string longestPalindrome(string s) {
        return lcs(s);
    }
};