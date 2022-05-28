// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[]=new int[V];
        
        for(int i=0;i<V;i++){
            if(color[i]==0){
                color[i]=1;
                if(dfs(adj,i,color)) return false;
            }
        }
        return true;
    }
    boolean dfs(ArrayList<ArrayList<Integer>>adj,int i,int color[]){
        
        for(int a:adj.get(i)){
            
            if(color[a]!=0){
                if(color[a]==color[i]) return true;
            }
            else{
                color[a]=-color[i];
                if(dfs(adj,a,color)) return true;
            }
        }
        return false;
    }
}