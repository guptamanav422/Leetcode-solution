class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int n=words.length;
        List<StringBuilder> arr[]=new ArrayList[130];
        for(int i=0;i<130;i++){
            arr[i]=new ArrayList<>();
        }
        for(String str:words){
            arr[str.charAt(0)].add(new StringBuilder(str));
        }
        
        int ans=0;
        for(char ch:s.toCharArray()){
            
            List<StringBuilder> list=arr[ch];
            arr[ch]=new ArrayList<>();
            
            for(StringBuilder ss:list){
                
                ss.deleteCharAt(0);
                
                if(ss.length()==0) ans++;
                else arr[ss.charAt(0)].add(ss);
            }
        }
        return ans;
    }
}