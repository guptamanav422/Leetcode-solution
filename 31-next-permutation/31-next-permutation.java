class Solution {
    public void nextPermutation(int[] arr)
    {
        int n=arr.length,i=n-1;
        for(i=n-2;i>=0;i--)
        {
            if(arr[i]<arr[i+1]) break;
        }
        if(i==-1){
            reverse(arr,0,n-1);
            return;
        }
        int j=n-1;
        for(j=n-1;j>=0;j--)
        {
            if(arr[j]>arr[i]) break;
        }
        swap(arr,i,j);
        reverse(arr,i+1,n-1);
    }
    void reverse(int arr[],int i,int j)
    {
        while(i<j)
        {
           swap(arr,i,j);
            i++;
            j--;
        }
    }
    void swap(int arr[],int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}