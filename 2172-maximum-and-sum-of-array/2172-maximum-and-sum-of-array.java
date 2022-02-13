class Solution {
    public int maximumANDSum(int[] nums, int ns) {
        
        int mask=(int)Math.pow(3,ns)-1;
        int dp[]=new int[mask+1];
        return find(nums,ns,nums.length-1,dp,mask);
    }
    int find(int arr[],int ns,int i,int dp[],int mask){
        
        if(i==-1) return 0;
        if(dp[mask]>0) return dp[mask];
        
        for(int bit=1,j=1;j<=ns;j++,bit*=3){
            
            if((mask/bit )%3 >0){
                dp[mask]=Math.max(dp[mask],(j&arr[i]) + find(arr,ns,i-1,dp,mask-bit));
            }
        }
        return dp[mask];
    }
}