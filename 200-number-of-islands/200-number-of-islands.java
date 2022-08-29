class Solution {
    int par[],rank[];
    int count=0;
    public int numIslands(char[][] grid)
    {
        int n=grid.length,m=grid[0].length;
        par=new int[n*m];
        rank=new int[n*m];
        for(int i=0;i<n*m;i++){
            par[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid[i][j]=='1'){
                    if(i!=0 && grid[i-1][j]=='1'){
                        union(i*m+j,(i-1)*m+j);
                    }
                    if(i!=n-1 && grid[i+1][j]=='1'){
                        union(i*m+j,(i+1)*m+j);
                    }
                    if(j!=0 && grid[i][j-1]=='1'){
                        union(i*m+j,i*m+j-1);
                    }
                    if(j!=m-1 && grid[i][j+1]=='1'){
                        union(i*m+j,i*m+j+1);
                    }
                    count++;
                }
                else par[i*m+j]=-1;
            }
        }
        return count;
    }
    int find(int a){
        // System.out.println(a);
        if(par[a]==a) return a;
        else {
            par[a]=find(par[a]);
            return par[a];
        }
    }
    void union(int a,int b){
        // System.out.println(a+" "+b);
        a=find(a);
        b=find(b);
        
        if(a!=b){
            if(rank[a]<rank[b]){
                int temp=a;
                a=b;
                b=temp;
            }
            
            par[b]=a;
            if(rank[a]==rank[b]) rank[a]++;
            count--;
        }
    }
}