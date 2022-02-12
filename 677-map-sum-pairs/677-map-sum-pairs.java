class MapSum {
    
    class Node{
        Node children[];
        boolean isLast;
        int score;
        Node(){
            children=new Node[26];
            isLast=true;
            score=0;
        }
    }
    Node root;
    public MapSum() {
        root=new Node();
    }
    
    public void insert(String key, int val) {
        
        Node r=root;
        for(char ch:key.toCharArray()){
            if(r.children[ch-'a']==null){
                r.children[ch-'a']=new Node();
            }
            r=r.children[ch-'a'];
        }
        r.score=val;
    }
    
    public int sum(String prefix) {
        Node r=root;
        for(char ch:prefix.toCharArray()){
            r=r.children[ch-'a'];
            if(r==null) return 0;
        }
        return find(r);
    }
    int find(Node r){
        if(r==null) return 0;
        int ans=r.score;
        
        for(int i=0;i<26;i++){
            ans+=find(r.children[i]);
        }
        return ans;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */