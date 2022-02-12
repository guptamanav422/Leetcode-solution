class Solution {
    public int slidingPuzzle(int[][] board) {
        String tar="123450";
        int arr[][]={{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        
        String str="";
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                str+=board[i][j];
            }
        }
        Set<String> set=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.add(str);
        int lev=0;
        set.add(str);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                
                String temp=q.remove();
                if(temp.equals(tar)){
                    return lev;
                }
                
                int idx=temp.indexOf('0');
                for(int a:arr[idx]){
                    String str1=swap(temp,idx,a);
                    if(set.contains(str1)) continue;
                    
                    q.add(str1);
                    set.add(str1);
                }
            }
            lev++;
        }
        return -1;
    }
    String swap(String temp,int i,int j){
        StringBuilder s=new StringBuilder(temp);
        char a=s.charAt(i),b=s.charAt(j);
        s.setCharAt(i,b);
        s.setCharAt(j,a);
        return s.toString();
    }
}