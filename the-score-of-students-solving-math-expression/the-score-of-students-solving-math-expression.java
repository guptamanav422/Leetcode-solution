class Solution {
    Map<String,Map<Integer,Integer>> map;
    public int scoreOfStudents(String s, int[] answers) {
        
        map=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        char prev='+';
        
        for(char ch:s.toCharArray()){
            
            if(ch>='0' && ch<='9'){
                st.push(ch-'0');
            }
            else{
                if(prev=='*'){
                    if(st.size()>1) st.push(st.pop()*st.pop());
                }
                
                prev=ch;
            }
        }
        
        if(st.size()>1 && prev=='*') st.push(st.pop()*st.pop());
        while(st.size()>1) st.push(calc(st.pop(),'+',st.pop()));
        int ans=st.pop();
        
        Map<Integer,Integer> help=find(s,0,s.length()-1);
        Map<Integer,Integer> ma=new HashMap<>();
        for(int a:answers){
            ma.put(a,ma.getOrDefault(a,0)+1);
        }
        int temp=0;
        for(int a:ma.keySet()){
            if(a==ans) temp+=5*ma.get(a);
            else if(help.containsKey(a)) temp+=2*ma.get(a);
        }
        return temp;
    }
    Map<Integer,Integer> find(String s,int st,int e){
        
        boolean flag=true;
        int len=s.length();
        
        StringBuilder sb=new StringBuilder();
        sb.append(st);
        sb.append(e);
        if(map.containsKey(sb.toString())) return map.get(sb.toString());
        Map<Integer,Integer> set=new HashMap<>();
        for(int i=st;i<=e;i++){
            
            char ch=s.charAt(i);
            if(ch=='+' || ch=='*'){
                Map<Integer,Integer> one=find(s,st,i-1);
                Map<Integer,Integer> two=find(s,i+1,e);
                
                for(int a:one.keySet()){
                    for(int b:two.keySet()){
                        int numa=calc(a,ch,b);
                        if(numa<=1000)
                        set.put(numa,0);
                    }
                }
                flag=false;
            }
        }
        
        if(flag){
            int numa=(Integer.parseInt(s.substring(st,e+1)));
            if(numa<=1000)       
            set.put(numa,0);
        }
        map.put(sb.toString(),set);
        return set;
    }
    int calc(int a,char ch,int b){
        return ch=='*'?a*b:a+b;
    }
}
    