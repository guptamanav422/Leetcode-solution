class Solution {
    public int eatenApples(int[] apples, int[] days) {
        boolean visit[]=new boolean[40000];
        
        int n=apples.length;
        int c=0;
        for(int i=n-1;i>=0;i--){
            
            int sum=i+days[i]-1;
            while(apples[i]>0 && sum>=i){
                if(!visit[sum]){
                    apples[i]--;
                    visit[sum]=true;
                    c++;
                }
                sum--;
            }
        }
        return c;
    }
}