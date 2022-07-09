class Solution {
    public int uniqueLetterString(String s) {
        int n=s.length();
        
        int arr[]=new int[26],temp[]=new int[n];
        Arrays.fill(arr,-1);
        for(int i=0;i<n;i++){
            
            int ii=s.charAt(i)-'A';
            temp[i]=(i-arr[ii]);
            arr[ii]=i;
        }
        int ans=0;
        Arrays.fill(arr,n);
        for(int i=n-1;i>=0;i--){
            
            int ii=s.charAt(i)-'A';
            ans+=temp[i]*(arr[ii]-i);
            arr[ii]=i;
        }
        return ans;
    }
}