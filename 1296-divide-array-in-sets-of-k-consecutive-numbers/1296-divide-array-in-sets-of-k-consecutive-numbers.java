class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        
        if(nums.length%k!=0) return false;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int a:nums){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        
        for(int a:map.keySet()){
            
            while(map.get(a)!=0){
                
                int num=map.get(a);
                for(int i=a;i<(a+k);i++){
                    
                    if(!map.containsKey(i) || map.get(i)<num){
                        return false;
                    }
                    map.put(i,map.get(i)-num);
                }
            }
        }
        return true;
    }
}