// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int n, int[][] arr)
    {
        int ind[]=new int[n];
        List<List<Integer>> gra=new ArrayList<>();
        for(int i=0;i<n;i++){
            gra.add(new ArrayList<>());
        }
        for(int a[]:arr){
            ind[a[1]]++;
            gra.get(a[0]).add(a[1]);
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(ind[i]==0) q.add(i);
        }
        int c=0;
        while(!q.isEmpty()){
            
            int a=q.remove();
            c++;
            for(int num:gra.get(a)){
                if(--ind[num]==0){
                    q.add(num);
                }
            }
        }
        return c==n;
    }
    
}