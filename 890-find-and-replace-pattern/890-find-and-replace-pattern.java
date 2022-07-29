class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        
        List<String> list=new ArrayList<>();
        for(String str:words){
            
            int a1[]=new int[26],a2[]=new int[26];            
            boolean ok=true;
            for(int i=0;i<str.length() && ok;i++){
                
                char a=str.charAt(i),b=pattern.charAt(i);
                
                if(a1[a-'a']==0 && a2[b-'a']==0){
                    a1[a-'a']=b;
                    a2[b-'a']=a;
                }
                else if(a1[a-'a']!=b || a2[b-'a']!=a) ok=false;
            }
            if(ok) list.add(str);
        }
        return list;
    }
}