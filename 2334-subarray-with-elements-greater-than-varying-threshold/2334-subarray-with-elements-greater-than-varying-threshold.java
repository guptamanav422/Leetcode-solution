class Solution {
    public int validSubarraySize(int[] nums, int th) {
        
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        st.push(n);
        int arr[]=new int[n];
        
        for(int i=n-1;i>=0;i--){
            while(st.peek()!=n && nums[st.peek()]>=nums[i]) st.pop();
            
            arr[i]=st.peek();
            st.push(i);
        }
        
        st=new Stack<>();
        st.push(-1);
        for(int i=0;i<n;i++){
            while(st.peek()!=-1 && nums[st.peek()]>=nums[i]) st.pop();
            
            int s=st.peek()+1,e=arr[i]-1;
            st.push(i);
            if(nums[i]>(th/(e-s+1))){
                // System.out.println(s+" "+e+" "+i);
                return e-s+1;
            }
        }
        return -1;
    }
}