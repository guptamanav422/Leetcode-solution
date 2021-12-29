class Solution {
    public int minTaps(int n, int[] ranges) {
        
        int ans[]=new int[n+1];
        Arrays.fill(ans,Integer.MAX_VALUE);
        
        for(int i=0;i<=n;i++){
            
            // if(ranges[i]==0) continue;
            int left=Math.max(0,i-ranges[i]);
            int right=Math.min(n,i+ranges[i]);
            
            int c=left==0?0:ans[left];
            
            if(c==Integer.MAX_VALUE) continue;
            for(int j=left;j<=right;j++){
                ans[j]=Math.min(ans[j],c+1);
            }
        }
        // for(int i=0;i<=n;i++){
        //     System.out.print(ans[i]+" ");
        // }
        return ans[n]==Integer.MAX_VALUE?-1:ans[n];
    }
}