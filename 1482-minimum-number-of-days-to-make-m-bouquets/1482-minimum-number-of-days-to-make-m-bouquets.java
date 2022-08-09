class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int n=bloomDay.length;
        if(n<m*k) return -1;
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        int ans=-1,st=min,en=max;
        while(st<=en){
            
            int mid=(st+en)/2;
            
            if(possible(bloomDay,mid,m,k)){
                ans=mid;
                en=mid-1;
            }
            else st=mid+1;
        }
        return ans;
    }
    boolean possible(int arr[],int mid,int m,int k){
        
        int j=k;
        for(int a:arr){
            if(a<=mid){
                j--;
            }
            else j=k;
            
            if(j==0){
                m--;
                j=k;
                if(m==0) return true;
            }
        }
        return false;
    }
}
