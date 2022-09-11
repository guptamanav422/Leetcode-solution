class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        Map<Integer,Set<Integer>> map=new HashMap<>();
        for(int i=0;i<routes.length;i++){
            
            for(int j=0;j<routes[i].length;j++){
                
                map.putIfAbsent(routes[i][j],new HashSet<>());
                
                map.get(routes[i][j]).add(i);
            }
        }
        
        int step=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(source);
        Set<Integer> set=new HashSet<>();
        // set.add(source);
        while(!q.isEmpty()){
            
            int size=q.size();
            while(size-->0){
                
                int num=q.remove();
                // System.out.println()
                if(num==target) return step;
                
                for(int a:map.get(num)){
                    
                    if(!set.contains(a)){
                        set.add(a);
                        
                        for(int aa:routes[a]){
                            q.add(aa);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}