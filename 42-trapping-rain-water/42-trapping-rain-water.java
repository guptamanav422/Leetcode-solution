class Solution {
    public int trap(int[] height) {
        int i=0,j=height.length-1;
        
        int ans=0,leftmax=0,rightmax=0;
        while(i<j){
            leftmax=Math.max(leftmax,height[i]);
            rightmax=Math.max(rightmax,height[j]);
            
            if(leftmax<=rightmax){
                ans+=leftmax-height[i];
                i++;
            }
            else{
                ans+=rightmax-height[j];
                j--;
            }
        }
        return ans;
    }
}