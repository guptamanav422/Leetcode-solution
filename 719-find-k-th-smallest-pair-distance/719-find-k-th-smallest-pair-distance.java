class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int n=nums.length;
        int s=0,e=nums[n-1]-nums[0],ans=0;
        
        while(s<=e){
            int mid=(s+e)/2;
            
            
            int count=0;
            for(int i=0,j=0;i<n;i++){
                while(j!=n && nums[j]-nums[i]<=mid) j++;
                count+=(j-i-1);
            }
            
            if(count>=k){
                ans=mid;
                e=mid-1;
            }
            else s=mid+1;
        }
        return ans;
    }
}