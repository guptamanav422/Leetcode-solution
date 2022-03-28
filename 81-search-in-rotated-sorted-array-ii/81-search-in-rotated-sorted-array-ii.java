class Solution {
    public boolean search(int[] nums, int target)
    {
        return find(nums,0,nums.length-1,target);
    }
    boolean find(int arr[],int s,int e,int tar)
    {
        while (s < e && arr[s] == arr[s + 1])
        ++s;
        while (s < e && arr[e] == arr[e - 1]) 
        --e;
        
        if(s>e) return false;
        
        int m=(s+e)/2;
        if(arr[m]==tar) return true;
        else if(arr[m]<=arr[e]){
            if(tar>arr[m] && tar<=arr[e]) return find(arr,m+1,e,tar);
            else return find(arr,s,m-1,tar);
        }
        else{
            if(tar>=arr[s] && arr[m]>tar) return find(arr,s,m-1,tar);
            else return find(arr,m+1,e,tar);
        }
    }
}