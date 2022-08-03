class Solution {
    public int[][] insert(int[][] intervals, int[] nn) {
        
        List<int []> ans=new ArrayList<>();
        int n=intervals.length;
        boolean flag=true;
        for(int i=0;i<=n;i++){
            
            int arr[]={};
            if(i<n) arr=intervals[i];
            else arr=nn;
            
            if(i<n && flag && intervals[i][0]>nn[0]){
                if(ans.isEmpty() || ans.get(ans.size()-1)[1]<nn[0])
                    ans.add(nn);
                else ans.get(ans.size()-1)[1]=Math.max(nn[1],ans.get(ans.size()-1)[1]);
                flag=false;
                i--;
            }
            else{
                if(ans.isEmpty() || ans.get(ans.size()-1)[1]<arr[0])
                    ans.add(arr);
                else ans.get(ans.size()-1)[1]=Math.max(arr[1],ans.get(ans.size()-1)[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}