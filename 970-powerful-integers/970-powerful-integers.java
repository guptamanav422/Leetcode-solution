class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        
        List<Integer> ans=new ArrayList<>();
        Queue<int []> pq=new PriorityQueue<>((int a[],int b[])->{
            int num1=(int)(Math.pow(x,a[0])+Math.pow(y,a[1]));
            int num2=(int)(Math.pow(x,b[0])+Math.pow(y,b[1]));
            
            return num1-num2;
        });
        
        pq.add(new int[]{0,0});
        Map<Integer,Set<Integer>> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        while(!pq.isEmpty()){
            
            int arr[]=pq.remove();
            int num=(int)(Math.pow(x,arr[0])+Math.pow(y,arr[1]));
            // System.out.println(arr[0]+" "+arr[1]);
            // if(set.contains(num)) continue;
            // set.add(num);
            
            map.putIfAbsent(arr[0],new HashSet<>());
            if(map.get(arr[0]).contains(arr[1])) continue;
            
            map.get(arr[0]).add(arr[1]);
            if(num>bound) break;
            if(!set.contains(num)) ans.add(num);
            set.add(num);
            
            if(x!=1) pq.add(new int[]{arr[0]+1,arr[1]});
            if(y!=1) pq.add(new int[]{arr[0],arr[1]+1});
        }
        return ans;
    }
}