// { Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        
        
        long min=1,max=1,ans=Long.MIN_VALUE;
        
        for(int a:arr){
            if(a<0){
                long temp=min;
                min=max;
                max=temp;
            }
            
            min=min*a;
            max=max*a;
            
            // System.out.println(min+" "+max);
            ans=Math.max(ans,max);
            if(min==0){
                min=max=1;
            }
            if(max<0) max=1;
        }
        return ans;
    }
}