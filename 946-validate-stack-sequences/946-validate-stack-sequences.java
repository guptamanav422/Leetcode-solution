class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i=0;
        Stack<Integer> st=new Stack<>();
        for(int j=0;j<pushed.length;j++){
            while(!st.isEmpty() && st.peek()==popped[i]){
                st.pop();
                i++;
            }
            st.push(pushed[j]);
        }
        while(!st.isEmpty() && st.peek()==popped[i]){
            st.pop();
            i++;
        }
        return i==pushed.length;
    }
}