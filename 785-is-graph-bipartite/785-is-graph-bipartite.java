class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int n=graph.length;
        int color[]=new int[n];
        
        for(int i=0;i<n;i++){
            if(color[i]==0){
                if(!find(1,i,graph,color)) return false;
            }
        }
        return true;
    }
    boolean find(int c,int i,int[][] graph,int color[]){
        
        if(color[i]!=0){
            if(color[i]==c) return true;
            return false;
        }
        
        color[i]=c;
        for(int a:graph[i]){
            if(!find(-c,a,graph,color)) return false;
        }
        return true;
    }
}