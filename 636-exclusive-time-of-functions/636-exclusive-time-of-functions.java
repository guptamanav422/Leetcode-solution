class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        
        int ans[]=new int[n];
        
        Stack<int []> st=new Stack<>();
        for(String str:logs){
            
            String s[]=str.split(":");
            int id=Integer.parseInt(s[0]);
            int time=Integer.parseInt(s[2]);
            
            if(s[1].equals("start")){
                st.push(new int[]{time,0});
            }
            else{
                int temp[]=st.pop();
                int num=time-temp[0]-temp[1]+1;
                ans[id]+=num;
                if(!st.isEmpty()) st.peek()[1]+=temp[1]+num;
                // System.out.println(num);
            }
        }
        return ans;
    }
}