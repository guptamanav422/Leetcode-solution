class Solution {
    public int shortestPathAllKeys(String[] grid) {
        
        int c=0;
        int n=grid.length,m=grid[0].length();
        Set<String> visit=new HashSet<>();
        Queue<int[]> q=new LinkedList<>();
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i].charAt(j)>='a' && grid[i].charAt(j)<='z'){
                    ans=ans| (1<<(grid[i].charAt(j)-'a'));
                }
                   
                if(grid[i].charAt(j)=='@'){
                    q.add(new int[]{i,j,0});
                    visit.add(i+","+j+","+0);
                }
            }
        }
        
        int s=0;
        int dir[][]={{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            
            int si=q.size();
            while(si-->0){
                int arr[]=q.remove();
                for(int k=0;k<4;k++){
                    
                    int x1=arr[0]+dir[k][0],y1=arr[1]+dir[k][1],key=arr[2];
                    if(key==ans) return s;
                    if(x1<0 || x1==n || y1<0 || y1==m || grid[x1].charAt(y1)=='#') continue;
                    
                    if(grid[x1].charAt(y1)>='a' && grid[x1].charAt(y1)<='z'){
                         key |=1<<(grid[x1].charAt(y1)-'a');
                    }
                    
                    if(grid[x1].charAt(y1)>='A' && grid[x1].charAt(y1)<='Z' && (key&(1<<(grid[x1].charAt(y1)-'A')))==0) continue;
                    
                    String ss=x1+","+y1+","+key;
                    if(!visit.contains(ss)){
                        visit.add(ss);
                        q.add(new int[]{x1,y1,key});
                    }
                }
            }
            s++;
        }
        return -1;
    }
}