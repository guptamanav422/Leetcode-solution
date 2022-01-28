class WordDictionary {

    /** Initialize your data structure here. */
    Map<Integer,List<String>> map;
    public WordDictionary() {
        map=new HashMap<>();
    }
    
    public void addWord(String word) {
        int len=word.length();
        if(!map.containsKey(len)) map.put(len,new ArrayList<>());
        map.get(len).add(word);
    }
    
    public boolean search(String word) {
        
        int len=word.length();
        if(map.containsKey(len)){
            
            for(String str:map.get(len)){
                
                boolean flag=true;
                for(int i=0;i<len;i++){
                    
                    if(word.charAt(i)=='.') continue;
                    if(str.charAt(i)!=word.charAt(i)){
                        flag=false;
                        break;
                    }
                }
                if(flag) return true;
            }
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