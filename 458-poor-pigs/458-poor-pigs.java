class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        
        if(buckets==1) return 0;
        int a=(minutesToTest)/minutesToDie+1;
        int c=1,a1=a;
        while(a<buckets){
            c++;
            a=a*a1;
        }
        return c;
    }
}