// { Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().distinctCount(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java




class Solution {
    int distinctCount(int[] arr, int n) {
        Arrays.sort(arr);
        
        int idx=-1;
        for(int i=0;i<n;i++){
            if(arr[i]>=0) break;
            idx=i;
        }
        
        int j=idx+1;
        int c=0;
        while(idx>=0 || j<n){
            int i1=idx,j1=j;
            if(j==n || (idx>=0 && -1*arr[idx]<=arr[j])){
                idx=dec(arr,idx);
            }
            if(i1<0 || (j<n && -1*arr[i1]>=arr[j])){
                j=gre(arr,j);
            }
            c++;
        }
        return c;
    }
    int gre(int arr[],int j){
        while(j<arr.length-1 && arr[j]==arr[j+1]) j++;
        return j+1;
    }
    int dec(int arr[],int idx){
        while(idx>0 && arr[idx]==arr[idx-1]) idx--;
        return idx-1;
    }
}
