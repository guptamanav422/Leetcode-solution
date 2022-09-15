class Solution {
    
    class Trie{
        
        Trie children[]=new Trie[2];
    }
    public int findMaximumXOR(int[] nums) {
        
        Trie root=new Trie();;
        
        for(int a:nums){
            
            Trie node=root;
            for(int i=31;i>=0;i--){
                int key=(a>>>i) & 1;
                
                if(node.children[key]==null){
                    node.children[key]=new Trie();
                }
                
                node=node.children[key];
            }
        }
        
        int ans=0;
        for(int a:nums){
            
            int temp=0;
            Trie node=root;
            for(int i=31;i>=0;i--){
                int key=(a>>>i) & 1;
                
                if(node.children[key^1]!=null){
                    temp+=1<<i;
                    node=node.children[key^1];
                }
                else if(node.children[key]!=null){
                    node=node.children[key];
                }
            }
            ans=Math.max(ans,temp);
        }
        return ans;
    }
}