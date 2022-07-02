class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts)
    {
        int n=horizontalCuts.length;
        int m=verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long max=h-horizontalCuts[n-1];
        int s=0;
        for(int a:horizontalCuts)
        {
            max=Math.max(max,a-s);
            s=a;
        }
        s=0;
        long max2=w-verticalCuts[m-1];
        for(int a:verticalCuts)
        {
            max2=Math.max(max2,a-s);
            s=a;
        }
        return (int)((max*max2)%1000000007);
    }
}