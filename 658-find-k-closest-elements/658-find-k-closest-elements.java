class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> ans=new ArrayList<>();
        
        int idx=Arrays.binarySearch(arr,x);
        
        if(idx<0){
            idx=-(idx+1);
            if(idx==arr.length) idx--;
            if(idx!=0 && (x-arr[idx-1])<=(arr[idx]-x)) idx--;
        }
        // System.out.println(idx);
        int s=idx-1,e=idx+1;
        k--;
        while(k>0){
            
            if(s<0) e++;
            else if(e==arr.length) s--;
            else if((x-arr[s]) <= (arr[e]-x)) s--;
            else e++;
            
            k--;
        }
        List<Integer> list=new ArrayList<>();
        for(int i=s+1;i<e;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}