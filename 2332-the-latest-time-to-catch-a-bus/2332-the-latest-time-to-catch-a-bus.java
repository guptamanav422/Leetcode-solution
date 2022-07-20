class Solution {
    public int latestTimeCatchTheBus(int[] bus, int[] pas, int cap) {
        
        Arrays.sort(bus);
        Arrays.sort(pas);
        
        int i=0,ans=0;
        Set<Integer> set=new HashSet<>();
        for(int a:bus){
            
            int c=0;
            while(i<pas.length && c<cap && pas[i]<=a){
                set.add(pas[i]);
                // if(!set.contains(pas[i]-1)) ans=pas[i]-1;
                c++;
                i++;
            }
            a=(c==cap)?pas[i-1]:a;
            while(a>0){
                if(!set.contains(a)){
                    ans=a;
                    break;
                }
                a--;
            }
            
        }
        return ans;
    }
}