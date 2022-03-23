class Solution {
    int dp[][];
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int n1=cuts.length;
        dp=new int[n1][n1];
        return find(0,n,cuts,0,cuts.length-1);
    }
    int find(int s,int e,int arr[],int st,int en){
        
        if(st>en) return 0;
        if(st==en) return e-s;
        
        
        if(dp[st][en]!=0) return dp[st][en];
        int ans=Integer.MAX_VALUE;
        for(int i=st;i<=en;i++){
            ans=Math.min(ans,e-s + find(s,arr[i],arr,st,i-1) + find(arr[i],e,arr,i+1,en));
        }
        return dp[st][en]=ans;
    }
}