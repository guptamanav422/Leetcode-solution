// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    // } Driver Code Ends


class Solution{
    
    int dp[][];
    int find(int arr[],int idx,int n,int v){
        if(v==0) return 0;
        if(dp[v][idx]!=Integer.MAX_VALUE) return dp[v][idx];
        
        int num=Integer.MAX_VALUE;
        for(int i=idx;i<n;i++){
            if(arr[i]<=v){
                num=Math.min(num,find(arr,i,n,v-arr[i]));
            }
        }
        return dp[v][idx]=(num==Integer.MAX_VALUE)?num:num+1;
    }
	public int minCoins(int coins[], int M, int V) 
	{ 
	    dp=new int[V+1][M];
	    for(int i=0;i<=V;i++){
	        Arrays.fill(dp[i],Integer.MAX_VALUE);
	    }
	    return find(coins,0,M,V)==Integer.MAX_VALUE?-1:dp[V][0];
	} 
}