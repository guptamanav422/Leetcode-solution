class Solution {
    public List<List<Integer>> combinationSum3(int k, int n)
    {
        List<List<Integer>> ans=new ArrayList<>();
        find(n,1,ans,k,new ArrayList<>());
        return ans;
    }
    void find(int n,int i,List<List<Integer>> ans,int k,List<Integer> temp)
    {
        if(k==0 && n==0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(k<=0 || n<=0) return;
        for(int j=i;j<=9;j++)
        {
            temp.add(j);
            find(n-j,j+1,ans,k-1,temp);
            temp.remove(temp.size()-1);
        }
    }
}