class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int n=matrix.length,m=matrix[0].length;
        
        int arr[]=new int[m];
        int ans=0;
        for(int i=0;i<n;i++){
            Stack<Integer> st=new Stack<>();
            st.push(-1);
            for(int j=0;j<=m;j++){
                
                if(j!=m) arr[j]=(matrix[i][j]=='0')?0:arr[j]+1;
                
                while(st.peek()!=-1 && (j==m || arr[st.peek()]>arr[j])){
                    ans=Math.max(ans,arr[st.pop()]*(j-1-st.peek()));
                }
                st.push(j);
            }
        }
        return ans;
    }
}