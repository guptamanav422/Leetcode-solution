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
            int phy[] = new int[n];
    		int chem[] = new int[n];
    		int math[] = new int[n];
            
            for (int i = 0; i < n; ++i)
                {
                    phy[i]=sc.nextInt();
                    chem[i]=sc.nextInt();
                    math[i]=sc.nextInt();
                }
		    
		    Solution ob = new Solution();
		    
		    ob.customSort (phy, chem, math, n);
    		for (int i = 0; i < n; ++i)
    			System.out.println(phy[i]+" " + chem[i] + " " + math[i]);

        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class pair{
        int a,b,c;
        pair(int i,int j,int k)
        {
            a=i;
            b=j;
            c=k;
        }
}
class Solution
{
    public void customSort (int phy[], int chem[], int math[], int N)
    {
        pair arr[]=new pair[N];
        for(int i=0;i<N;i++)
        {
            arr[i]=new pair(phy[i],chem[i],math[i]);
        }
        
        Arrays.sort(arr,new Comparator<pair>(){
            // @Override
            public int compare(pair temp1,pair temp2)
            {
                if(temp1.a!=temp2.a)
                return temp1.a-temp2.a;
                else{
                    if(temp1.b!=temp2.b)
                    return temp2.b-temp1.b;
                    else return  temp1.c-temp2.c;
                }
            }
        });
        for(int i=0;i<N;i++)
        {
            phy[i]=arr[i].a;
            chem[i]=arr[i].b;
            math[i]=arr[i].c;
        }
    }
}
