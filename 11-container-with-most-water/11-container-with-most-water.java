class Solution {
    public int maxArea(int[] height) {
        int s=0,e=height.length-1;
        int ans=0;
        while(s<e)
        {
            if(height[s]<=height[e])
            {
                ans=Math.max(ans,(e-s)*height[s]);
                s++;
            }
            else{
                ans=Math.max(ans,(e-s)*height[e]);
                e--;
            }
        }
        return ans;
    }
}