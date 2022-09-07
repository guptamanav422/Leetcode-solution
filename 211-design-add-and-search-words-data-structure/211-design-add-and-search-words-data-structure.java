class WordDictionary {

    /** Initialize your data structure here. */
    class Node{
        Node children[];
        boolean isLast;
        
        Node(){
            children=new Node[26];
            isLast=false;
        }
    }
    Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node a=root;
        for(int i=0;i<word.length();i++){
            if(a.children[word.charAt(i)-'a']==null) 
                a.children[word.charAt(i)-'a']=new Node();
            a=a.children[word.charAt(i)-'a'];
        }
        a.isLast=true;
    }
    
    public boolean search(String word) {
        
        return check(word,root,0);
    }
    boolean check(String str,Node temp,int i){
        if(temp==null) return false;
        if(i==str.length()) return temp.isLast;
        
        if(str.charAt(i)!='.') return check(str,temp.children[str.charAt(i)-'a'],i+1);
        for(int j=0;j<26;j++){
            if(check(str,temp.children[j],i+1)) return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */