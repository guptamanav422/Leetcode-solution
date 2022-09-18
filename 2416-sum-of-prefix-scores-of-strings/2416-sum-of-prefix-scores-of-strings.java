class Solution {
    class Trie{
        
        int c=0;
        Trie children[];
        Trie(){
            children=new Trie[26];
        }
    }
    public int[] sumPrefixScores(String[] words) {
        
        Trie root=new Trie();
        
        for(String str:words){
            
            Trie node=root;
            for(char ch:str.toCharArray()){
                
                if(node.children[ch-'a']==null) node.children[ch-'a']=new Trie();
                
                node=node.children[ch-'a'];
                node.c++;
            }
        }
        
        int n=words.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            
            int count=0;
            Trie node=root;
            for(char ch:words[i].toCharArray()){
                node=node.children[ch-'a'];
                count+=node.c;
            }
            ans[i]=count;
        }
        return ans;
    }
}