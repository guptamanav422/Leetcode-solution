class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        
        int arr[]=new int[26];
        for(char ch:letters){
            arr[ch-'a']++;
        }
        
        return find(words,arr,score,0);
    }
    int find(String words[],int arr[],int score[],int i){
        
        if(i==words.length) return 0;
        
        int ans=find(words,arr,score,i+1);
        int tot=0;
        for(char ch:words[i].toCharArray()){
            
            if(tot!=-1) tot+=score[ch-'a'];
            arr[ch-'a']--;
            if(arr[ch-'a']<0){
                tot=-1;
            }
        }
        if(tot!=-1) ans=Math.max(ans,tot+find(words,arr,score,i+1));
        
        for(char ch:words[i].toCharArray()){
            arr[ch-'a']++;
        }
        return ans;
    }
}