class Solution {
    public boolean isPossible(int[] nums) {
        
        Map<Integer,Integer> left=new HashMap<>(),end=new HashMap<>();
        for(int a:nums){
            left.put(a,left.getOrDefault(a,0)+1);
        }
        for(int a:nums){
            if(left.get(a)==0) continue;
            
            left.put(a,left.get(a)-1);
            if(end.getOrDefault(a-1,0)>0){
                end.put(a-1,end.get(a-1)-1);
                end.put(a,end.getOrDefault(a,0)+1);
            }
            else if(left.getOrDefault(a+1,0)>=1 && left.getOrDefault(a+2,0)>=1){
                left.put(a+1,left.get(a+1)-1);
                left.put(a+2,left.get(a+2)-1);
                end.put(a+2,end.getOrDefault(a+2,0)+1);
            }
            else return false;
        }
        return true;
    }
}