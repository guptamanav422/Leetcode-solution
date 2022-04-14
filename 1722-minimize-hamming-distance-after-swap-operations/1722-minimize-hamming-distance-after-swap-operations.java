class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        int n=source.length;
        int par[]=new int[n];
        Map<Integer,Map<Integer,Integer>> map1=new HashMap<>();
        for(int i=0;i<n;i++){
            par[i]=i;
        }        
        for(int arr[]:allowedSwaps){
            int a=find(arr[0],par);
            int b=find(arr[1],par);
            
            par[b]=a;
        }
        
        for(int i=0;i<n;i++){
            
            int pa=find(par[i],par);
            if(!map1.containsKey(pa)){
                map1.put(pa,new HashMap<>());
            }
            map1.get(pa).put(source[i],map1.get(pa).getOrDefault(source[i],0)+1);
        }
        
        int c=0;
        for(int i=0;i<n;i++){
            int pa=find(i,par);
            int num=map1.get(pa).getOrDefault(target[i],0);
            if(num==0) continue;
            c++;
            map1.get(pa).put(target[i],num-1);
        }
        return n-c;
        
    }
    int find(int a,int par[]){
        if(a==par[a]) return a;
        return par[a]=find(par[a],par);
    }
}