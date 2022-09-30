class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings)
    {
        List<int []> height=new ArrayList<>();
        for(int arr[]:buildings){
            height.add(new int[]{arr[0],-arr[2]});
            height.add(new int[]{arr[1],arr[2]});
        }
        
        Collections.sort(height, (a, b) -> {
            if(a[0] != b[0]) 
                return a[0] - b[0];
            return a[1] - b[1];
         });
        
        Queue<Integer> q=new PriorityQueue<>((a,b)->(b-a));
        List<List<Integer>> ans=new ArrayList<>();
        q.add(0);
        int prev=0;
        for(int h[]:height)
        {
            if(h[1]<0){
                q.add(-h[1]);
            }
            else{
                q.remove(h[1]);
            }
            
            int curr=q.peek();
            if(prev!=curr){
                List<Integer> temp=new ArrayList<>();
                temp.add(h[0]);
                temp.add(curr);
                ans.add(temp);
                prev=curr;
            }
        }
        return ans;
    }
}