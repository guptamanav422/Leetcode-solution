class Solution {
    public int jump(int[] nums) {
        
        int c=0,n=nums.length;
        for(int i=0,max=0,temp=0;i<n && max<(n-1);i++){
            temp=Math.max(temp,i+nums[i]);
            if(max==i){
                c++;
                max=temp;
            }
        }
        return c;
    }
}