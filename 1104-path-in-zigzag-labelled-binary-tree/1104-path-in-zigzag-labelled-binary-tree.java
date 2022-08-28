class Solution {
    int  nextPowerOfTwo ( int  n )
    {
        int value = 1;
        while(value<=n)
        {
            value=value << 1;
        }
        return value ;
    }

    int  previousPowerOfTwo(int  n )
    {
        while((n&n-1)!=0)
        {
            n=n&n-1;
        }
        return  n ;
    }
    public List<Integer> pathInZigZagTree(int label) {
        
        List<Integer> ans=new ArrayList<>();
        
        while(label!=1){
            ans.add(label);
            
            int num=label/2;
            if(num==1) break;
            
            int next=nextPowerOfTwo(num);
            int prev=previousPowerOfTwo(num);
            
            next--;
            
            label=next-(num-prev);
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
}