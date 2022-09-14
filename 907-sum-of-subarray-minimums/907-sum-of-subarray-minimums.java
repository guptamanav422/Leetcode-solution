class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        st.push(n);
        int ans=0;
        
        int nums[]=new int[n];
        for(int i=n-1;i>=0;i--){
            
            while(st.peek()!=n && arr[st.peek()]>=arr[i]) st.pop();
            
            nums[i]=(st.peek()-i);
            // System.out.print(nums[i]+" ");
            st.push(i);
        }
        st=new Stack<>();
        st.push(-1);
        
        for(int i=0;i<n;i++){
            
            while(st.peek()!=-1 && arr[st.peek()]>arr[i]) st.pop();
            
            ans=(int)(((long)ans+(long)arr[i]*(long)nums[i]*(long)(i-st.peek()))%(long)1000000007);
            st.push(i);
        }
        return ans;
    }
}

// 4 3 2 1