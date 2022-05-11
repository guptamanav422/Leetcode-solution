class Solution {
    public int countVowelStrings(int n) {
        
        int k=5;
        int arr[][]=new int[n][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                
                arr[i][j]=((i==0)?1:arr[i-1][j]) + (j==0?0:arr[i][j-1]);
            }
        }
        return arr[n-1][k-1];
    }
}