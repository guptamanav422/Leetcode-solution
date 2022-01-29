class Solution {
    public int largestRectangleArea(int[] heights)
    {
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int n=heights.length;
        int ans=0;
        for(int i=0;i<=n;i++)
        {
            while(st.peek()!=-1 && (i==n || heights[st.peek()]>=heights[i]))
            {
                int num=heights[st.pop()];
                ans=Math.max(ans,num*(i-st.peek()-1));
            }
            if(i!=n) st.push(i);
        }
        return ans;
    }
}