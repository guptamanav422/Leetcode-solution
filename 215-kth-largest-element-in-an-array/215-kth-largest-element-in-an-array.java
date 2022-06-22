class Solution {
    public int findKthLargest(int[] nums, int k) {
        return kthlargest(nums,0,nums.length-1,k);
    }
    int kthlargest(int[] arr, int l, int r, int k) 
    { 
        int s=find(arr,l,r);
        int num=arr.length-s;
        if(num==k) return arr[s];
    
        if(num<k) return kthlargest(arr,l,s-1,k);
        else return kthlargest(arr,s+1,r,k);
    } 
    int find(int arr[],int l,int r){
        
        Random rn= new Random();
        int num=rn.nextInt(r-l+1);
        swap(arr,r,l+num);
        int s=l,i=s;
        while(i<r){
            if(arr[i]<=arr[r]){
                if(i==s) i++;
                else swap(arr,i,s);
                s++;
            }
            else i++;
        }
        swap(arr,s,r);
        return s;
    }
    void swap(int arr[],int l,int r){
        int temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
    }
}