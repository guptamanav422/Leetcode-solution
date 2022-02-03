// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		System.out.println (new Sol().search (arr, n));
        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int search(int arr[], int N)
    {
        int s=0,e=N-1;
        while(s<=e){
            
            int m=(s+e)/2;
            
            if((m==0 || arr[m]!=arr[m-1]) && (m==N-1 || arr[m]!=arr[m+1])) return arr[m];
            
            if(m!=0 && arr[m]==arr[m-1]) m--;
            
            if((m-s)%2!=0){
                e=m-1;
            }
            else s=m+2;
        }
        return -1;
    }
}