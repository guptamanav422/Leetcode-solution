// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            String a = S[0];
            String b = S[1];

            Solution ob = new Solution();
            System.out.println(ob.getLastDigit(a,b));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int getLastDigit(String a, String b) {
       int b1=-1;
       if(b.length()==1){
           b1=Integer.parseInt(b);
       }
       else b1=Integer.parseInt(b.substring(b.length()-2));
       
       int a1=Integer.parseInt(a.substring(a.length()-1));
    //   System.out.println(a1);
       
       if(b1==0) return 1;
       b1=b1%4;
       if(b1==0) b1=4;
       int ans=1;
       while(b1-->0){
           ans=(ans*a1)%100;
       }
       return ans%10;
    }
};