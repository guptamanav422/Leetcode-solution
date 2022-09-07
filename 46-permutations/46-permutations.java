class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        
        int n=nums.length;
        ans=new ArrayList<>();
        find(nums,new ArrayList<>(),new boolean[n],0);
        return ans;
    }
    void find(int arr[],List<Integer> temp,boolean visit[],int count){
        
        if(count==arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=0;i<arr.length;i++){
            if(!visit[i]){
                
                visit[i]=true;
                temp.add(arr[i]);
                find(arr,temp,visit,count+1);
                temp.remove(temp.size()-1);
                visit[i]=false;
            }
        }
        
    }
}