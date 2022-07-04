class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int left[]=new int[n],right[]=new int[n];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        
        for(int i=1;i<n;i++){
            int j=n-1-i;
            
            if(ratings[i]>ratings[i-1]) left[i]=left[i-1]+1;
            if(ratings[j]>ratings[j+1]) right[j]=right[j+1]+1;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.max(left[i],right[i]);
        }
        return ans;
    }
}