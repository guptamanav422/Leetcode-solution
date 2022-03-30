class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        ans=new ArrayList<>();
        Arrays.sort(candidates);
        find(candidates,0,target,new ArrayList<>());
        return ans;
    }
    void find(int arr[],int i,int tar,List<Integer> list){
        if(tar<0) return;
        if(tar==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i==arr.length) return ;
        
        for(int j=i;j<arr.length;j++){
            if(j!=i && arr[j]==arr[j-1]) continue;
            
            list.add(arr[j]);
            find(arr,j+1,tar-arr[j],list);
            list.remove(list.size()-1);
        }
    }
}