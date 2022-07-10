class Solution {
    public int minimumOperations(int[] nums) {
        
        Map<Integer,Integer> m1=new HashMap<>(),m2=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            
            if(i%2==0){
                m1.put(nums[i],m1.getOrDefault(nums[i],0)+1);
            }
            else m2.put(nums[i],m2.getOrDefault(nums[i],0)+1);
        }
        
        int m11=0,m12=0,val1=0;
        int m21=0,m22=0,val2=0;
        
        for(int a:m1.keySet()){
            if(m11<m1.get(a)){
                m12=m11;
                m11=m1.get(a);
                val1=a;
            }
            else if(m12<m1.get(a)) m12=m1.get(a);
        }
        
        for(int a:m2.keySet()){
            if(m21<m2.get(a)){
                m22=m21;
                m21=m2.get(a);
                val2=a;
            }
            else if(m22<m2.get(a)) m22=m2.get(a);
        }
        
        int a1=(n+1)/2,a2=n/2;
        
        if(val1!=val2) return a1-m11 + a2-m21;
        else return Math.min(a1-m11 + a2-m22,  a1-m12+a2-m21);
        
    }
}