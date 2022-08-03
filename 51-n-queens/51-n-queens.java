class Solution {
    List<List<String>> ans;
    boolean col[],leftDia[],rightDia[];
    StringBuilder sb;
    public List<List<String>> solveNQueens(int n) {
        
        ans=new ArrayList<>();
        col=new boolean[n];
        leftDia=new boolean[2*n];
        rightDia=new boolean[2*n];
        
        sb=new StringBuilder();
        for(int j=0;j<n;j++){
            sb.append(".");
        } 
        find(0,n,new ArrayList<>());
        return ans;
    }
    void find(int i,int n,List<String> list){
        
       if(i==n){
           ans.add(new ArrayList<>(list));
           return;
       }
        
        StringBuilder temp=new StringBuilder(sb);
        for(int j=0;j<n;j++){
            
            if(!col[j] && !leftDia[i+j] && !rightDia[n-1-i+j]){
                temp.setCharAt(j,'Q');
                list.add(temp.toString());
                col[j]=leftDia[i+j]=rightDia[n-1-i+j]=true;
                find(i+1,n,list);
                col[j]=leftDia[i+j]=rightDia[n-1-i+j]=false;
                list.remove(list.size()-1);
                temp.setCharAt(j,'.');
            }
            
        }
    
    }
}