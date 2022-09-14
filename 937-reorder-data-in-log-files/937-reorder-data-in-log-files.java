class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        
        Comparator<String> comp=new Comparator<>(){
            
            public int compare(String s1,String s2){
                
                int i1=s1.indexOf(' ');
                int i2=s2.indexOf(' ');
                
                char ch1=s1.charAt(i1+1);
                char ch2=s2.charAt(i2+1);
                
                if(ch1<='9' && ch1>='0'){
                    if(ch2<='9' && ch2>='0'){
                        return 0;
                    }
                    return 1;
                }
                
                if(ch2<='9' && ch2>='0'){
                    return -1;
                }
                
                int c=s1.substring(i1+1).compareTo(s2.substring(i2+1));
                if(c==0) return s1.substring(0,i1).compareTo(s2.substring(0,i2));
                return c;
            }
        };
        
        Arrays.sort(logs,comp);
        return logs;
    }
}