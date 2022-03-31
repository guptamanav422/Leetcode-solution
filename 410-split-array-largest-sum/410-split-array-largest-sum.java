class Solution {
    public int splitArray(int[] nums, int m)
    {
        int sum=0;
        for(int a:nums) sum+=a;
        
        int s=0,e=sum,ans=0;
        while(s<=e){
            int mid=(s+e)/2;
            if(possible(nums,m,mid)){
                ans=mid;
                e=mid-1;
            }
            else s=mid+1;
        }
        return ans;
    }
    boolean possible(int arr[],int m,int mid){
        
        int temp=0;
        for(int i=0;i<arr.length;){
            if(temp+arr[i]>mid){
                m--;
                temp=0;
                if(m==0) return false;
            }
            else{
                temp+=arr[i];
                i++;
            }
        }
        return true;
    }
}