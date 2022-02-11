class Trie {
    class Node{
        Node children[];
        boolean isLast;
        
        Node(){
            children=new Node[26];
            isLast=false;
        }
    }
    
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        
        Node a=root;
        for(int i=0;i<word.length();i++){
            if(a.children[word.charAt(i)-'a']==null) 
                a.children[word.charAt(i)-'a']=new Node();
            a=a.children[word.charAt(i)-'a'];
        }
        a.isLast=true;
    }
    
    public boolean search(String word) {
        Node a=root;
        for(int i=0;i<word.length();i++){
            if(a.children[word.charAt(i)-'a']==null) return false;
            a=a.children[word.charAt(i)-'a'];
        }
        return a.isLast;
    }
    
    public boolean startsWith(String word) {
        Node a=root;
        for(int i=0;i<word.length();i++){
            if(a.children[word.charAt(i)-'a']==null) return false;
            a=a.children[word.charAt(i)-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */