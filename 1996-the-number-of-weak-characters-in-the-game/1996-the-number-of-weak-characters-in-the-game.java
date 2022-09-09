class Solution {
    public int numberOfWeakCharacters(int[][] arr) {
        
        Arrays.sort(arr,(int a[],int b[])->(a[0]==b[0])?(b[1]-a[1]):(a[0]-b[0]));
        
        int n=arr.length,ans=0,max=Integer.MIN_VALUE;
        for(int i=n-1;i>=0;i--){
            
            if(arr[i][1]<max){
                ans++; 
            }
            else max=arr[i][1];
        }
        return ans;
    }
}