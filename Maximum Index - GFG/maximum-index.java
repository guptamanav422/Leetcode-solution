// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxIndexDiff(arr, n));
        }
    }
}// } Driver Code Ends


class Solution {

    int maxIndexDiff(int arr[], int n) {
        int max[]=new int[n],min[]=new int[n];
        max[n-1]=arr[n-1];
        min[0]=arr[0];
        for(int i=1;i<n;i++){
            int j=n-1-i;
            max[j]=Math.max(max[j+1],arr[j]);
            min[i]=Math.min(min[i-1],arr[i]);
        }
        int i=0,j=0,ans=0;
        while(i<n && j<n){
            while(j<n && min[i]<=max[j]) j++;
            ans=Math.max(ans,j-i-1);
            while(i<n-1 && min[i]==min[i+1]) i++;
            i++;
        }
        return ans;
    }
}