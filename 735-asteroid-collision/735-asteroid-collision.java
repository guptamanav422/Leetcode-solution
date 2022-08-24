class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> st=new Stack<>();
        for(int a:asteroids){
            boolean ok=true;
            while(!st.isEmpty() && st.peek()>0 && a<0){
                int num=st.pop();
                if(Math.abs(a)==Math.abs(num)){
                    ok=false;
                    break;
                }
                else if(Math.abs(a)<Math.abs(num)){
                    a=num;
                }
            }
            
            if(ok) st.push(a);
        }
        int ans[]=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}