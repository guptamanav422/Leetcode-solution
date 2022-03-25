class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        long l=left,r=right;
        int ll=find(left),rr=find(right);
        
        if(ll!=rr) return 0;
        // System.out.println(rr);
        int ab=(int)Math.pow(2,ll);
        long ans=left;
        for(long i=left;i<=right;i++){
            ans=ans&i;
            if(ans==ab) return ab; 
        }
        return (int)ans;
        
    }
    int find(long l){
        long s=1;
        int c=0;
        while(s<=l){
            c++;
            s*=2;
        }
        return c-1;
    }
}