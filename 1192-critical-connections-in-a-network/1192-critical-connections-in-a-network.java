class Solution {
    int low[],dis[],time=1;
    List<Integer>[] graph;
    List<List<Integer>> ans;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        graph= new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(List<Integer> oneConnection :connections) {
            graph[oneConnection.get(0)].add(oneConnection.get(1));
            graph[oneConnection.get(1)].add(oneConnection.get(0));
        }
        low=new int[n];
        dis=new int[n];
        ans=new ArrayList<>();
        time=1;
        dfs(0,-1);
        return ans;
    }
    
    void dfs(int node,int par){
        
        dis[node]=low[node]=time++;
        
        for(int neighbor: graph[node]){
            if (dis[neighbor] == 0){ // ignore parent
                dfs(neighbor,node);
                
                low[node]=Math.min(low[node],low[neighbor]);
                
                if(low[neighbor]>dis[node]){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(node);
                    temp.add(neighbor);
                    ans.add(temp);
                }
            }
            else if(neighbor!=par){
                low[node]=Math.min(low[node],low[neighbor]);
            }
        }
    }
}