class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        for(int i=0;i<4;i++){
            
            if(check(mat,target)) return true;
            rotate(mat);
        }
        return false;
    }
    boolean check(int arr1[][],int arr2[][]){
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(arr1[i][j]!=arr2[i][j]) return false;
            }
        }
        return true;
    }
    void rotate(int arr[][]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp=arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i]=temp;
            }
        }
        
        
        for(int i=0;i<n;i++){
            reverse(arr[i]);
        }
    }
    void reverse(int arr[]){
        int s=0,e=arr.length-1;
        while(s<e){
            
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }
}