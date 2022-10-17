class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] seen = new boolean[26];
        int count = 0;
        
        for(char ch: sentence.toCharArray()) {
            if(!seen[ch - 'a']) {
                seen[ch - 'a'] = true;
                count++;
            }
            if(count == 26) break;
        }
        
        return count == 26;
    }
}