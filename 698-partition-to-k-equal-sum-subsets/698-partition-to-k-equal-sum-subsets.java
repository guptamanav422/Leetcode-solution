class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum=0;
        for(int a:nums){
            sum+=a;
        }
        if(sum%k!=0) return false;
        return check(nums,0,0,0,k,sum/k,new boolean[nums.length]);
    }
    boolean check(int arr[],int sum,int c,int i,int k,int tot,boolean visit[]){
        
        if(c==k) return true;
        
        if(sum==tot) return check(arr,0,c+1,0,k,tot,visit);
        
        
        for(int j=i;j<visit.length;j++){
            if(visit[j] || sum+arr[j]>tot) continue;
            
            visit[j]=true;
            if(check(arr,sum+arr[j],c,j+1,k,tot,visit)) return true;
            visit[j]=false;
        }
        return false;
    }
}