class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int max=trips[0][2];
        for(int arr[]:trips){
            max=Math.max(max,arr[2]);
        }
        
        int ans[]=new int[max+1];
        for(int arr[]:trips){
            ans[arr[1]]+=arr[0];
            ans[arr[2]]-=arr[0];
        }
        for(int i=0;i<=max;i++){
            if(i!=0) ans[i]+=ans[i-1];
            
            if(ans[i]>capacity) return false;
        }
        return true;
    }
}