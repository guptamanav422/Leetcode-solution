// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //Taking input using class Scanner
		Scanner sc=new Scanner(System.in);
		
		//Taking total count of testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    
		    int n,m;
		    
		    //taking size of array a
		    n=sc.nextInt();
		    
		    //taking size of array b
		    m=sc.nextInt();
		    
		    //Creating 2 array of size n and m
		    int a[]=new int[n];
		    int b[]=new int[m];
		    
		    //inserting elements to array a
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    
		    //inserting elements to array b
		    for(int i=0;i<m;i++)
		    {
		        b[i]=sc.nextInt();
		    }
		    Solution ob=new Solution();
		    //calling doUnion method and printing the results
		    System.out.println(ob.doUnion(a,n,b,m));
		}
		
	}
}// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int doUnion(int a[], int n, int b[], int m) 
    {
        Arrays.sort(a);
        Arrays.sort(b);
        
        int i=0,j=0;
        int c=0;
        while(i<n || j<m){
            
            while(i<n && i!=0 && a[i]==a[i-1]) i++;
            while(j<m && j!=0 && b[j]==b[j-1]) j++;
            
            if(i==n && j==m) break;
            if(i==n){
                j++;
            }
            else if(j==m){
                i++;
            }
            else{
                if(a[i]==b[j]){
                    i++;
                    j++;
                }
                else if(a[i]>b[j]){
                    j++;
                }
                else i++;
            }
            c++;
        }
        return c;
    }
}