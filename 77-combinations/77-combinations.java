class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        
        find(1,n,k,new ArrayList<>());
        return ans;
    }
    void find(int i,int n,int k,List<Integer> list){
        if(k==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i>n) return;
        
        list.add(i);
        find(i+1,n,k-1,list);
        list.remove(list.size()-1);
        
        find(i+1,n,k,list);
    }
}