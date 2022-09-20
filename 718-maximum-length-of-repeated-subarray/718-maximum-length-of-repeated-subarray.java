class Solution {
    int dp[][];
    int ans=0;
    public int findLength(int[] nums1, int[] nums2) {
        int n=nums1.length,m=nums2.length;
        dp=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        find(nums1,nums2,0,0);
        return ans;
    }
    int find(int a1[],int a2[],int i,int j){
        
        if(i==a1.length || j==a2.length) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        
        // dp[i][j]=Math.max();
        
        int temp=0;
        if(a1[i]==a2[j]){
            temp=find(a1,a2,i+1,j+1)+1;
            ans=Math.max(ans,temp);
        }
        find(a1,a2,i+1,j);
        find(a1,a2,i,j+1);
        return dp[i][j]=temp;
    }
}