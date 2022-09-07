class Solution {
    int dp[][];
    public int mctFromLeafValues(int[] arr) {
        
        int n=arr.length;
        dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return find(arr,0,n-1);
    }
    int find(int arr[],int s,int e){
        if(s==e) return 0;
        
        if(dp[s][e]!=-1) return dp[s][e];
        int ans=Integer.MAX_VALUE;
        for(int i=s;i<e;i++){
            
            ans=Math.min(ans, findMax(arr,s,i)*findMax(arr,i+1,e) + find(arr,s,i) + find(arr,i+1,e));
            // System.out.println(findMax(arr,s,i)*findMax(arr,i+1,e)+" "+s+" "+e);
        }
        return dp[s][e]=ans;
    }
    int findMax(int arr[],int s,int e){
        
        int maxEle=Integer.MIN_VALUE;
        for(int i=s;i<=e;i++){
            
            maxEle=Math.max(maxEle,arr[i]);
        }
        // System.out.println(s+" "+e+" "+maxEle);
        return maxEle;
    }
}