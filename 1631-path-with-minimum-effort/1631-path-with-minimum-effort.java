class Solution {
    public static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        int n = heights.length;
        int m = heights[0].length;
        Integer[][] minDist = new Integer[n][m];
        minDist[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int arr[]=pq.remove();
            // System.out.println(arr[0]+" "+arr[1]);
            if(arr[0]==n-1 && arr[1]==m-1) return arr[2];
            for(int a[]:dirs)
            {
                int a1=a[0]+arr[0];
                int a2=a[1]+arr[1];
                if(a1<0 || a1>=n || a2<0 || a2>=m) continue;
                int effort=Math.max(arr[2],Math.abs(heights[a1][a2]-heights[arr[0]][arr[1]]));
                if(minDist[a1][a2]==null || effort<minDist[a1][a2])
                {
                   minDist[a1][a2]=effort;
                   pq.add(new int[]{a1,a2,minDist[a1][a2]});   
                }
            }
        }
        // System.out.println(n+" "+m);
        return -1;
    }
}