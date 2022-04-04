class Solution {
    public int[] countPairs(int n, int[][] edges, int[] qu) {
        
        int ind[]=new int[n+1],cnt[]=new int[n+1];
        int ans[]=new int[qu.length];
        Map<Integer,Integer> map[]=new HashMap[n+1];
        for(int arr[]:edges){
            ind[arr[0]]=cnt[arr[0]]=ind[arr[0]]+1;
            ind[arr[1]]=cnt[arr[1]]=ind[arr[1]]+1;
            
            int n1=Math.min(arr[0],arr[1]),n2=Math.max(arr[0],arr[1]);
            if(map[n1]==null) map[n1]=new HashMap<>();
            map[n1].put(n2,map[n1].getOrDefault(n2,0)+1);
        }
        Arrays.sort(cnt);
        for(int i=0;i<qu.length;i++){
            for(int i1=1,j1=n;i1<j1;){
                if(cnt[i1]+cnt[j1]>qu[i]) ans[i]+=(j1--)-i1;
                else i1++;
            }
            
            for(int i1=1;i1<=n;i1++){
                if(map[i1]==null) continue;
                
                for(var aa:map[i1].entrySet()){
                    int key=aa.getKey(),val=aa.getValue();
                    if(ind[i1]+ind[key]>qu[i] && ind[i1]+ind[key]-val<=qu[i]) ans[i]--;
                }
            }
        }
        return ans;
    }
}