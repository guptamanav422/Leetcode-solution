// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]A,int N,int M)
    {
        if(M>N) return -1;
        long s=0L,e=0L;
        for(int a:A){
            s=Math.max(s,a);
            e+=a;
        }
        
        long ans=-1;
        while(s<=e){
            long mid=(s+e)/2;
            // System.out.println(mid);
            if(possible(A,mid,M)){
                e=mid-1;
                ans=mid;
            }
            else s=mid+1;
        }
        return (int) ans;
    }
    static boolean possible(int arr[],long mid,int m){
        long sum=0;
        for(int a:arr){
            if(sum+a>mid){
                sum=a;
                m--;
            }
            else sum+=a;
            if(m==0) return false;
        }
        return true;
    }
};