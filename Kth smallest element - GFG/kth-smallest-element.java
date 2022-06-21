// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        int idx=pivot(arr,l,r);
        // System.out.println(idx+" ");
        if(idx==k-1) return arr[idx];
        else if(idx>=k) return kthSmallest(arr,l,idx-1,k);
        else return kthSmallest(arr,idx+1,r,k);
        // return 7;
    } 
    static int pivot(int arr[],int l,int r){
        
        int s=l,i=l;
        Random rn=new Random();
        int ab=rn.nextInt(r-l+1);;
        swap(arr,r,l+ab);
        while(i<r){
            if(arr[i]<=arr[r]){
                swap(arr,i,s);
                s++;
            }
            i++;
        }
        swap(arr,s,i);
        return s;
    }
    static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
