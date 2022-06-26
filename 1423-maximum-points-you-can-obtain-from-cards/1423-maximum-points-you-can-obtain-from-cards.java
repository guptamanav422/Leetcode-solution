class Solution {
    public int maxScore(int[] arr, int k) {
        int sum=0,n=arr.length;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        int ans=sum;
        
        int i=k-1;
        while(i>=0){
            
            sum-=arr[i];
            sum+=arr[n-1-(k-1-i)];
            ans=Math.max(ans,sum);
            i--;
            // System.out.println(ans);
        }
        return ans;
    }
}