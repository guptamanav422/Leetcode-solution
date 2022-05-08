// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        if(n==1 && m==1) return M[0][0];
        int ans=0;
        for(int i=m-1;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                if(i!=m-1)
                {
                    int num=0;
                    if(j!=0) num=Math.max(num,M[j-1][i+1]);
                    num=Math.max(num,M[j][i+1]);
                    if(j!=n-1) num=Math.max(num,M[j+1][i+1]);
                    M[j][i]+=num;
                }
                if(i==0) ans=Math.max(ans,M[j][i]);
            }
        }
        return ans;
    }
}