class Solution {
    int ans=0;
    public int reversePairs(int[] nums) {
        
        int n=nums.length;
        ans=0;
        mergeSort(nums,0,n-1);
        return ans;
    }
    void mergeSort(int arr[],int s,int e){
        if(s>=e) return;
        
        int mid=(s+e)/2;
        
        mergeSort(arr,s,mid);
        mergeSort(arr,mid+1,e);
        
        merge(arr,s,mid,e);
    }
    void merge(int arr[],int s,int m,int e){
        
        
        int i=s,j=m+1;
        while(i<=m && j<=e){
            
            boolean ok=((long)arr[i]>(long)((long)arr[j]*2));
            
            if(ok){
                ans+=m-i+1;
                j++;
            }
            else i++;
        }
        Arrays.sort(arr,s,e+1);
    }
}