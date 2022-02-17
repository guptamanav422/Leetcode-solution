// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long ans=0;
    static long inversionCount(long arr[], long N)
    {
        ans=0;
        mergeSort(arr,0,(int)N-1);
        return ans;
    }
    static void mergeSort(long arr[],int s,int e){
        
        
        if(s>=e) return;
        int m=(s+e)/2;
        mergeSort(arr,s,m);
        mergeSort(arr,m+1,e);
        
        merge(arr,s,m,e);
    }
    static void merge(long arr[],int s,int m,int e){
        
        long temp[]=new long[e-s+1];
        
        int i=s,j=m+1,k=0;
        
        while(i<=m || j<=e){
            
            if(i>m){
                temp[k++]=arr[j++];
            }
            else if(j>e){
                temp[k++]=arr[i++];
            }
            else{
                
                if(arr[i]<=arr[j]){
                    temp[k++]=arr[i++];
                }
                else if(arr[i]>arr[j]){
                    temp[k++]=arr[j++];
                    
                    ans+=m-i+1;
                }
            }
        }
        
        for(i=s;i<=e;i++){
            arr[i]=temp[i-s];
        }
    }
    
    // 4
    // 3,5
    
    // (m-i+1)
    
    
}