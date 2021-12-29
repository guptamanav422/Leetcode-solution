class Solution {
    public int videoStitching(int[][] clips, int time) {
        
        int ans[]=new int[time+1];
        
        for(int ar[]:clips){
            
            if(ar[0]>=time) continue;
            ans[ar[0]]=Math.max(ans[ar[0]],ar[1]);
        }
        
        int temp=0,end=0;
        for(int i=0,farthest=0;end<time; end=farthest){
            temp++;
            while(i<=time && i<=end){
                farthest=Math.max(farthest,ans[i]);
                i++;
            }
            // System.out.println(farthest+" "+i);
            if(end==farthest) return -1;
        }
        return temp;
        
    }
}