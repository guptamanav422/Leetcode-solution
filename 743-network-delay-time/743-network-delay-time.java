class Solution {
    class Edge implements Comparable<Edge>{
        
        int v,w;
        Edge(int a,int b){
            v=a;
            w=b;
        }
        
        public int compareTo(Edge b){
            return this.w-b.w;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        
        for(int arr[]:times){
            list.get(arr[0]).add(new Edge(arr[1],arr[2]));
        }
        
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        
        pq.add(new Edge(k,0));
        boolean visit[]=new boolean[n+1];
        int ans=-1;
        while(!pq.isEmpty()){
            
            Edge temp=pq.remove();
            if(visit[temp.v]) continue;
            visit[temp.v]=true;
            n--;
            ans=temp.w;
            
            for(Edge a:list.get(temp.v)){
                
                if(!visit[a.v]){
                    pq.add(new Edge(a.v,a.w+temp.w));
                }
            }
        }
        return n==0?ans:-1;
    }
}