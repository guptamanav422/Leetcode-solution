class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans=0,count=0,prev=0,n=nums.length;
        for(int i=0;i<n;){
            
            int j=prev;
            while(i<n){
                if(nums[i]==0){
                    if(count==k) break;
                    count++;
                }
                i++;
            }

            ans=Math.max(ans,i-j);

            while(j<n){
                if(nums[j]==0){
                    count--;
                    if(count<k) break;
                }
                j++;
            }
            prev=j+1;
        }
        return ans;
    }
}