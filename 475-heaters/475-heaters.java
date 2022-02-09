class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        
        int max=0;
        TreeSet<Integer> set=new TreeSet<>();
        for(int a:heaters){
            set.add(a);
        }
        
        int ans=-1;
        for(int a:houses){
            
            Integer ceil=set.ceiling(a),floor=set.floor(a);
            
            int num;
            if(ceil==null){
                num=a-floor;
            }
            else if(floor==null){
                num=ceil-a;
            }
            else num=Math.min(a-floor,ceil-a);
            
            // System.out.println(num+" "+floor);
            ans=Math.max(ans,num);
        }
        return ans;
    }
}