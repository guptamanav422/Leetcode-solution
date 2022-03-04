class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        
        int n=nums.length;
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=1;i<=100;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            map.get(nums[i]).add(i);
        }
        
        int n1=queries.length;
        int ans[]=new int[n1];
        for(int i=0;i<n1;i++){
            
            int prev=-1;
            int s=queries[i][0],e=queries[i][1];
            int min=-1;
            for(int k=1;k<=100;k++){
                
                int idx=Collections.binarySearch(map.get(k),s);
                
                if(idx<0){
                    idx=-1*(idx+1);
                }
                if(idx==map.get(k).size() || map.get(k).get(idx)>e){
                     continue;
                }
                
                if(prev!=-1){
                    if(min==-1) min=k-prev;
                    else min=Math.min(min,k-prev);
                }
                prev=k;
            }
            ans[i]=min;
        }
        return ans;
    }
}