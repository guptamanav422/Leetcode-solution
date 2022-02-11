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
        
        return check(word,0,word.length(),root);
    }
    boolean check(String word,int i,int n,Node temp){
      
        if(temp==null) return false;
        if(i==n) return temp.isLast;
        
        if(word.charAt(i)=='.'){
            for(int j=0;j<26;j++){
                if(check(word,i+1,n,temp.children[j])) return true;
            }
        }
        else return check(word,i+1,n,temp.children[word.charAt(i)-'a']);
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */