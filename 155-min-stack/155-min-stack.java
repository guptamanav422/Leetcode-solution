class MinStack {

    /** initialize your data structure here. */
    Stack<Long> st;
    long min;
    public MinStack() {
        st=new Stack<>();
        // min=0;
    }
    
    public void push(int val) {
        if(st.size()==0){
            st.push((long)val);
            min=val;
        }
        else{
            if(min>val){
                st.push((long)2*val-(long)min);
                min=val;
            }
            else{
                st.push((long)val);
            }
        }
    }
    
    public void pop() {
        long num=st.pop();
        if(num<min) min=2*min-num;
    }
    
    public int top() {
        if(st.peek()<min) return (int)min;
        else {
            long temp=st.peek();
            return (int) temp;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */