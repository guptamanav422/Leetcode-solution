class Solution {
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        k%=len;
        if(k==0) return;
        reverse(nums,len-k,len-1);
        reverse(nums,0,len-k-1);
        reverse(nums,0,len-1);
    }
    void reverse(int arr[],int s,int e){
        while(s<e){
            int temp=arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }
}