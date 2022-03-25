class Solution {
    int ans=0;
    int dp[][];
    public int twoCitySchedCost(int[][] costs) {
        
        int n=costs.length;
        int ref[]=new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            ref[i]=costs[i][1]-costs[i][0];
            ans+=costs[i][0];
        }
        System.out.println(ans);
        Arrays.sort(ref);
        for(int i=0;i<n/2;i++){
            ans+=ref[i];
            // System.out.println(ref[i])
        }
        return ans;
    }
}