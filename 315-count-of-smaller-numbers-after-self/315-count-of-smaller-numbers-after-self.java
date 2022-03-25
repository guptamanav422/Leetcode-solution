class Solution {
    class pair{
        int idx,num;
        pair(int a,int b){
            idx=a;
            num=b;
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
        if(s>=e) return ;
        
        int m=(s+e)/2;
        mergeSort(arr,s,m);
        mergeSort(arr,m+1,e);
        merge(arr,s,m,e);
    }
    void merge(pair arr[],int s,int m,int e){
        
        pair ans[]=new pair[e-s+1];
        int i=m,j=e,k=e-s;
        while(i>=s || j>m){
            if(i<s){
                // int idx=arr[i].idx;
                // list.set(idx,list.get(idx)+e-m);
                ans[k--]=arr[j--];
            }
            else if(j==m){
                ans[k--]=arr[i--];
            }
            else{
                if(arr[i].num>arr[j].num){
                    int idx=arr[i].idx;
                    list.set(idx,list.get(idx)+(j-m));
                    ans[k--]=arr[i--];
                }
                else{
                    ans[k--]=arr[j--];
                }
            }
        }
        for(i=s;i<=e;i++){
            arr[i]=ans[i-s];
        }
    }
    
}