class Solution {
    int ans=-1;
    int dp[];
    public int maxScore(int[] nums) {
        
        int n=nums.length;
        dp=new int[1<<(n+1)];
        boolean visit[]=new boolean[n];
        int ans=find(nums,visit,1,0,0);
        // for(int a:dp){
        //     System.out.print(a+" ");
        // }
        return ans;
    }
    int find(int arr[],boolean visit[],int i,int c,int ab){
        
        if(c==arr.length){
            return 0;
        }
        
        if(dp[ab]==0)
        for(int ii=0;ii<arr.length;ii++){
            if(visit[ii]) continue;
            
            for(int jj=ii+1;jj<arr.length;jj++){
                if(visit[jj]) continue;
                
                visit[ii]=visit[jj]=true;
                dp[ab]=Math.max(dp[ab],(gcd(arr[ii],arr[jj])*i)+find(arr,visit,i+1,c+2, ab|(1<<(ii+1))|(1<<(jj+1))));
                visit[ii]=visit[jj]=false;
            }
        }
        return dp[ab];
    }
    int gcd(int a,int b){
        if(a%b==0) return b;
        return gcd(b,a%b);
    }
}