class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        Map<Integer,Integer> map=new HashMap<>();
        for(int a:changed){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        Arrays.sort(changed);
        int n=changed.length,i=0;
        int ans[]=new int[n/2];
        if(n%2!=0) return new int[0];
        for(int a:changed){
            if(map.get(a)==0) continue;
            
            // System.out.println(a);
            if(map.getOrDefault(2*a,0)<map.get(a) || (a==0 && map.get(a)%2!=0)) return new int[0];
            
            int min=(a==0)?map.get(a)/2:map.get(a);
            for(int j=0;j<min;j++){
                ans[i++]=a;
            }
            map.put(a,map.get(a)-min);
            map.put(2*a,map.get(2*a)-min);
        }
        return ans;
    }
}