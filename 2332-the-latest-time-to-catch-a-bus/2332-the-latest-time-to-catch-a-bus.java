class Solution {
    public int latestTimeCatchTheBus(int[] bus, int[] pas, int cap) {
        
        Arrays.sort(bus);
        Arrays.sort(pas);
        
        int j=0,n=pas.length;
        Set<Integer> set=new HashSet<>();
        for(int a:pas){
            set.add(a);
        }
        int ans=0;
        for(int i=0;i<bus.length;i++){
            
            int c=0;
            
            while(j<n && c<cap && pas[j]<=bus[i]){
                
                if(!set.contains(pas[j]-1)) ans=pas[j]-1;
                j++;
                c++;
            }
            
            
            if(c<cap){
                while(set.contains(bus[i])){
                    bus[i]--;
                }
                ans=bus[i];
            }
        }
        return ans;
    }
}