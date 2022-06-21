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
            int k = Integer.parseInt(inputLine[0]);
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, n, k);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        
        int hash[]=new int[n];
        int c=0;
        List<int []> list=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            
            list.add(new int[]{i,arr[i]+k});
            list.add(new int[]{i,arr[i]-k});
        }
        Collections.sort(list, new Comparator<>(){
            public int compare(int a[],int b[]){
                return a[1]-b[1];
            }
        });
        
        int i=0,s=i,ans=Integer.MAX_VALUE,nn=list.size();
        while(i<nn){
            
            while(c<n && i<nn){
                int aa[]=list.get(i);
                hash[aa[0]]++;
                if(hash[aa[0]]==1) c++;
                i++;
            }
            if(c!=n) break;
            while(s<i){
                int aa[]=list.get(s++);
                ans=Math.min(ans,list.get(i-1)[1]-aa[1]);
                hash[aa[0]]--;
                if(hash[aa[0]]==0){
                    c--;
                    break;
                }
            }
        }
        return ans;
    }
}
