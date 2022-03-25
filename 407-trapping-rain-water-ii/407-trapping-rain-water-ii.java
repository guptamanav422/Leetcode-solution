class Solution {
    class pair implements Comparable<pair>{
        int r,c,h;
        pair(int a,int b,int d){
            r=a;
            c=b;
            h=d;
        }
        public int compareTo(pair aa){
            return this.h-aa.h;
        }
    }
    public int trapRainWater(int[][] arr) {
        
        
        int n=arr.length,m=arr[0].length;
        boolean visit[][]=new boolean[n][m];
        PriorityQueue<pair> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(new pair(i,0,arr[i][0]));
            visit[i][0]=true;
            pq.add(new pair(i,m-1,arr[i][m-1]));
            visit[i][m-1]=true;
        }
        for(int i=0;i<m;i++){
            pq.add(new pair(0,i,arr[0][i]));
            visit[0][i]=true;
            pq.add(new pair(n-1,i,arr[n-1][i]));
            visit[n-1][i]=true;
        }
        int ans=0;
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        while(!pq.isEmpty()){
            pair te=pq.remove();
            for(int i=0;i<4;i++){
                int xx=te.r+dir[i][0],yy=te.c+dir[i][1];
                if(xx<0 || xx==n || yy<0 || yy==m || visit[xx][yy]) continue;
                ans+=Math.max(0,te.h-arr[xx][yy]);
                visit[xx][yy]=true;
                pq.add(new pair(xx,yy,Math.max(te.h,arr[xx][yy])));
            }
        }
        return ans;
    }
}