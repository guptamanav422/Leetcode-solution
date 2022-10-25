class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        
        int i=0,j=0,id1=0,id2=0;
        
        while(i<word1.length && j<word2.length){
            
            if(word1[i].charAt(id1)!=word2[j].charAt(id2)) return false;
            
            id1++;
            id2++;
            
            if(word1[i].length()==id1){
                i++;
                id1=0;
            }
            if(word2[j].length()==id2){
                j++;
                id2=0;
            }
        }
        return i==word1.length && j==word2.length;
    }
}