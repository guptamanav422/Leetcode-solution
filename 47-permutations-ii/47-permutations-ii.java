class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        Arrays.sort(nums);
        ans=new ArrayList<>();
        find(nums,new ArrayList<>(),new boolean[nums.length],0);
        return ans;
    }
    void find(int arr[],List<Integer> temp,boolean visit[],int c){
        if(c==arr.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=0;i<arr.length;i++){
            if((i!=0 && arr[i]==arr[i-1] && !visit[i-1]) || visit[i] ) continue;
            
            temp.add(arr[i]);
            visit[i]=true;
            find(arr,temp,visit,c+1);
            temp.remove(temp.size()-1);
            visit[i]=false;
        }
    }
}