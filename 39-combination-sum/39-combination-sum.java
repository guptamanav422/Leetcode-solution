class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> list=new ArrayList<>();
        
        if(candidates.length==0 || target<=0) return list;
        
        combinationSumHelper(candidates,0,target,new ArrayList<>(),list);
        return list;
    }
    void combinationSumHelper(int arr[],int start,int tar,List<Integer> temp,List<List<Integer>> ans){
        
        if(tar==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=start;i<arr.length;i++){
            if(arr[i]>tar) continue;
            
            temp.add(arr[i]);
            combinationSumHelper(arr,i,tar-arr[i],temp,ans);
            temp.remove(temp.size()-1);
        }
    }
}