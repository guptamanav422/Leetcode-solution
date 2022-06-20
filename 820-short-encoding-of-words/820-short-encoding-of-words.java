class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        int ans=0;
        int n=words.length;
        boolean vis[]=new boolean[n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && !vis[j]){
                    int idx=words[j].lastIndexOf(words[i]);
                    if(idx!=-1 && (idx+words[i].length())==words[j].length()){
                        vis[i]=true;
                        break;
                    }
                }
            }
            if(!vis[i]) ans+=words[i].length()+1;
        }
        return ans;
    }
}