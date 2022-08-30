class Solution {
    
    int par1[],par2[];
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        par1=new int[n+1];
        par2=new int[n+1];
        
        for(int i=0;i<=n;i++){
            par1[i]=i;
            par2[i]=i;
        }
        int ans=0;
        int c1=0,c2=0;
        for(int edge[]:edges){
            
            if(edge[0]!=3) continue;
            int u=find(edge[1],par1);
            int v=find(edge[2],par1);
            
            if(u==v){
                ans++;
                continue;
            }
            c1++;
            c2++;
            par1[v]=u;
            par2[v]=u;
        }
        for(int edge[]:edges){
            
            if(edge[0]==3) continue;
            int u=find(edge[1],((edge[0]==1)?par1:par2));
            int v=find(edge[2],((edge[0]==1)?par1:par2));
            
            if(u==v){
                ans++;
                continue;
            }
            if(edge[0]==1) c1++;
            else c2++;
            int arr[]=(edge[0]==1)?par1:par2;
            arr[v]=u;
        }
        return (c1==(n-1) && (c2==n-1))?ans:-1;
        
    }
    int find(int a,int par[]){
        if(par[a]==a) return a;
        return par[a]=find(par[a],par);
    }
}