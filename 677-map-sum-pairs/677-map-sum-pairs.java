class MapSum {
    
    class Node{
        Node children[];
        int score;
        Node(){
            children=new Node[26];
            score=0;
        }
    }
    Node root;
    Map<String,Integer> map=new HashMap<>();
    public MapSum() {
        root=new Node();
    }
    
    public void insert(String key, int val) {
        
        int val1=val;
        val=val-map.getOrDefault(key,0);
        map.put(key,val1);
        Node r=root;
        for(char ch:key.toCharArray()){
            if(r.children[ch-'a']==null){
                r.children[ch-'a']=new Node();
            }
            r=r.children[ch-'a'];
            r.score+=val;
        }
    }
    
    public int sum(String prefix) {
        Node r=root;
        for(char ch:prefix.toCharArray()){
            r=r.children[ch-'a'];
            if(r==null) return 0;
        }
        return r.score;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */