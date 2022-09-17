class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n=nums.length;
        int dp[]=new int[n];
        int cc[]=new int[n];
        int ans=1,max=1;
        Arrays.fill(dp,1);
        Arrays.fill(cc,1);
        for(int i=1;i<n;i++){
            
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[i]<(dp[j]+1)){
                        cc[i]=cc[j];
                        dp[i]=dp[j]+1;
                    }
                    else if(dp[i]==(dp[j]+1)){
                        cc[i]+=cc[j];
                    }
                }
            }
            if(dp[i]>max){
                max=dp[i];
                ans=cc[i];
            }
            else if(dp[i]==max){
                ans+=cc[i];
            }
        }
        
        // for(int a:dp){
        //     System.out.print(a+" ");
        // }
        // System.out.println();
        // for(int a:cc){
        //     System.out.print(a+" ");
        // }
        // System.out.println();
        // System.out.println(max);
        return ans;
    }
}