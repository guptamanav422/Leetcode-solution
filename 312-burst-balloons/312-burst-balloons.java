class Solution {
    int dp[][]=new int[302][302];
    int find(int arr[],int s,int e){
        if(s>=e) return 0;
        
        if(dp[s][e]!=0) return dp[s][e];
        for(int k=s;k<e;k++){
            dp[s][e]=Math.max(dp[s][e],arr[s-1]*arr[k]*arr[e]+find(arr,s,k)+find(arr,k+1,e));
        }
        return dp[s][e];
    }
    public int maxCoins(int[] nums) {
        
        
        int n=nums.length;
        int arr[]=new int[n+2];
        for(int i=1;i<=n;i++){
            arr[i]=nums[i-1];
            Arrays.fill(dp[i],0);
        }
        arr[0]=arr[n+1]=1;
        
        return find(arr,1,n+1);
    }
}