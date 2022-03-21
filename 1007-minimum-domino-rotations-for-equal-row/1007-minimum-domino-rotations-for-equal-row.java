class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int ans=Math.min(find(tops[0],tops,bottoms),find(bottoms[0],tops,bottoms));
        // System.out.println(ans);
        ans=Math.min(ans,Math.min(find(tops[0],bottoms,tops),find(bottoms[0],bottoms,tops)));
        
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    int find(int i,int tops[],int bottoms[]){
        int c=-1,n=tops.length;
        for(int j=0;j<n;j++){

            if(tops[j]==i) c=c;
            else if(bottoms[j]==i) c++;
            else break;
            
            if(j==n-1) return c+1;
        }
        return Integer.MAX_VALUE;
    }
}