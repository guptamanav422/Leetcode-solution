class Solution {
    public long distinctNames(String[] ideas) {
        
         HashSet<Integer> set[]=new HashSet[26];
        for(int i=0;i<26;i++){
            set[i]=new HashSet<>();
        }
        for(String str:ideas){
            set[str.charAt(0)-'a'].add(str.substring(1).hashCode());
        }
        long ans=0;
        for(int i=0;i<26;i++){
            for(int j=i+1;j<26;j++){

                int c=0;
                for(int a:set[i]){
                   if(set[j].contains(a)) c++;
                }
                ans+=(set[i].size()-c)*(set[j].size()-c);
            }
        }
        return ans*2;
    }
}