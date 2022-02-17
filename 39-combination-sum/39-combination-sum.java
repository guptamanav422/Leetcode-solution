class Solution {
    List<List<Integer>>  ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans=new ArrayList<>();
        
        find(candidates,target,0,new ArrayList<>());
        return ans;
    }
    void find(int arr[],int tar,int i,List<Integer> temp){
        if(i==arr.length || tar<0) return;
        
        if(tar==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        temp.add(arr[i]);
        find(arr,tar-arr[i],i,temp);
        temp.remove(temp.size()-1);
        
        find(arr,tar,i+1,temp);
    }
}