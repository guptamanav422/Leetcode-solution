class CountIntervals {
    
    TreeMap<Integer,Integer> map=new TreeMap<>();
    int cnt=0;
    public CountIntervals() {
        cnt=0;
        map=new TreeMap<>();
    }
    
    public void add(int left, int right) {
        
        var it=map.floorEntry(left);
        if(it==null || it.getValue()<left){
            it=map.higherEntry(left);
        }
        
        for(;it!=null && it.getKey()<=right;it=map.higherEntry(left)){
            
            left=Math.min(left,it.getKey());
            right=Math.max(right,it.getValue());
            
            cnt-=it.getValue()-it.getKey() +1;
            map.remove(it.getKey());
            
        }
        map.put(left,right);
        cnt+=right-left+1;
    }
    
    public int count() {
        return cnt;
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */