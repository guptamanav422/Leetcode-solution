class Solution {
    int temp=Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        
        check(jobs,0,0,new int[k]);
        return temp;
    }
    void check(int arr[],int i,int max,int worker[]){
        
        if(i==arr.length){
            temp=Math.min(temp,max);
            return;
        }
        if(max>temp) return;
        
        for(int j=0;j<worker.length;j++){
            
            worker[j]+=arr[i];
            check(arr,i+1,Math.max(max,worker[j]),worker);
            worker[j]-=arr[i];
            
            if(worker[j]==0) break;
        }
    }
}