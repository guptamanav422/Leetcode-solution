class Solution {
    class pair{
        int ind,val;
        pair(int a,int b){
            ind=a;
            val=b;
        }
    }
    List<Integer> list=new ArrayList<>();
    public List<Integer> countSmaller(int[] nums) {
       
        int n=nums.length;
        
        pair arr[]=new pair[n];
        for(int i=0;i<n;i++){
            arr[i]=new pair(i,nums[i]);
            list.add(0);
        }
        
        mergeSort(arr,0,n-1);
        return list;
    }
    void mergeSort(pair arr[],int s,int e){
        if(s>=e) return;
        
        int m=(s+e)/2;
        mergeSort(arr,s,m);
        mergeSort(arr,m+1,e);
        merge(arr,s,m,e);
    }
    void merge(pair arr[],int s,int m,int e){
        pair ans[]=new pair[e-s+1];
        int i=s,j=m+1;
        int k=0;
        while(i<=m && j<=e){
            if(arr[i].val<=arr[j].val){
                int ind=arr[i].ind;
                // int num=k-i+s;
                list.set(ind,list.get(ind)+j-m-1);
                ans[k++]=arr[i++];
            }
            else{
               ans[k++]=arr[j++];
            }
        }
        while(i<=m){
            int ind=arr[i].ind;
            list.set(ind,list.get(ind)+e-m);
            ans[k++]=arr[i++];
        }
        while(j<=e){
           ans[k++]=arr[j++]; 
        }
        k=0;
        for(i=s;i<=e;i++){
            arr[i]=ans[k++];
        }
    }
}