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
        
        int n1=m-s+1,n2=e-m;
        long a1[]=new long[n1],a2[]=new long[n2];
        
        for(int i=s;i<=e;i++){
            if(i<=m) a1[i-s]=arr[i];
            else a2[i-m-1]=arr[i];
        }
        for(int j=0;j<n2;j++){
            int idx=Arrays.binarySearch(a1,2*a2[j]);
            if(idx<0) idx=-(idx+1);
            else while(idx<a1.length && a1[idx]==2*a2[j]) idx++;
            ans+=n1-idx;
        }
        int i=0,j=0,k=s;
        while(i<n1 && j<n2){
            
            if(a1[i]<a2[j]){
                arr[k++]=(int)a1[i++];
            }
            else{arr[k++]=(int)a2[j++];
            }
        }
        
        while(i<n1){
            arr[k++]=(int)a1[i++];
        }
        
        while(j<n2){
            arr[k++]=(int)a2[j++];
        }
        // System.out.println(s+" "+m+" "+e+" "+ans);
    }
}