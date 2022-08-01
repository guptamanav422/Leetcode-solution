class Solution {
    boolean visit[];
    int ans=-1,edge[];
    void bfs(int node){    
        Map<Integer,Integer> map=new HashMap<>();
        map.put(node,1);
        visit[node]=true;
        for(int c=2;edge[node]!=-1;c++){
            node=edge[node];
            if(map.containsKey(node)){
                ans=Math.max(ans,c-map.get(node));
                break;
            }
            if(visit[node]) break;
            visit[node]=true;
            map.put(node,c);
        }
    }
    public int longestCycle(int[] edges) {
        
        edge=edges;
        int n=edges.length;
        ans=-1;
        visit=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visit[i]) bfs(i);
        }
        return ans;
    }
}