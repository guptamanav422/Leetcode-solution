class Solution {
    public int maximumGroups(int[] grades) {
        
        int ans=0,n=grades.length;
        if(n==1) return 1;
        for(int i=0,j=1;i+j<=n;i+=j,j++) ans++;
        return ans;
    }
}