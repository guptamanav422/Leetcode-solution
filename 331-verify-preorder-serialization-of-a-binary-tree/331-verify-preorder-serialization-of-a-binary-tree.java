class Solution {
    class pair{
        int l;
        String str;
        pair(String a,int b){
            str=a;
            l=b;
        }
    }
    public boolean isValidSerialization(String pre) {
        
        String arr[]=pre.split(",");
        if(arr.length==1 && arr[0].equals("#")) return true;
        Stack<pair> st=new Stack<>();
        for(int i=0;i<arr.length;i++){
            
            String ss=arr[i];
            if(ss.equals("#")){
                if(st.isEmpty()) return false;
            }
            if(!st.isEmpty()){
                if(st.peek().l==1) st.pop();
                else st.peek().l++;
            }
            
            if(!ss.equals("#")){
                st.push(new pair(ss,0));
            }
            
            if(st.isEmpty() && i!=arr.length-1) return false;
        }
        return st.isEmpty();
    }
}