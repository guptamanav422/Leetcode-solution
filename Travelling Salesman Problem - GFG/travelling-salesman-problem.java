// { Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(br.readLine().trim());
            int[][] cost = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    cost[i][j] = Integer.parseInt(S[j]);
            }
            Solution obj = new Solution();
            int ans = obj.total_cost(cost);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int ans=Integer.MAX_VALUE;
    public int total_cost(int[][] cost)
    {
        int n=cost.length;
        boolean visit[]=new boolean[n];
        find(0,1,0,cost,visit);
        return ans;
    }
    void find(int i,int c,int tot,int cost[][],boolean visit[]){
        
        if(c==cost.length){
            ans=Math.min(ans, tot+cost[i][0]);
            return;
        }
        visit[i]=true;
        for(int j=0;j<cost.length;j++){
            if(!visit[j]){
                find(j,c+1,tot+cost[i][j],cost,visit);
            }
        }
        visit[i]=false;
    }
}
