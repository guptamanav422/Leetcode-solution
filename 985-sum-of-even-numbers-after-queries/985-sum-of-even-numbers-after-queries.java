class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int n=queries.length,ans=0;
        int arr[]=new int[n];
        for(int a:nums){
            if(a%2==0) ans+=a;
        }
        
        int i=0;
        for(int a[]:queries){
            
            if(nums[a[1]]%2==0) ans-=nums[a[1]];
            nums[a[1]]+=a[0];
            if(nums[a[1]]%2==0) ans+=nums[a[1]];
            
            arr[i++]=ans;
        }
        return arr;
    }
}