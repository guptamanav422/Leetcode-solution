class Solution {
    Set<String> ans=new HashSet<>();
    void find(int l,int r,String s,int i){
        if(l==0 && r==0){
            if(valid(s)) ans.add(s);
            return;
        }
        if(i==s.length()) return;
        
        if(s.charAt(i)=='(' && r!=0) find(l,r-1,s.substring(0,i)+s.substring(i+1),i);
        else if(s.charAt(i)==')' && l!=0) find(l-1,r,s.substring(0,i)+s.substring(i+1),i);
        
        find(l,r,s,i+1);
        
    }
    public List<String> removeInvalidParentheses(String s) {
        int l=0,r=0,a=0;
        for(char ch:s.toCharArray()){
            if(ch=='(') a++;
            else if(ch==')') a--;
            
            if(a<0){
                l++;
                a=0;
            }
        }
        r=a;
        find(l,r,s,0);
        return new ArrayList<>(ans);
    }
    boolean valid(String s){
        int a=0;
        for(char ch:s.toCharArray()){
            if(ch=='(') a++;
            else if(ch==')')a--;
            if(a<0) return false;
        }
        return a==0;
    }
}