class Solution {
    public int minSetSize(int[] arr) {
        
        Map<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        int a1[]=new int[n+1];
        
        for(int a:arr){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        
        for(int a:map.keySet()){
            a1[map.get(a)]++;
        }
        
        int count=0,num=0;
        for(int i=arr.length;i>=1 && count<n/2 ;i--){
            if(a1[i]==0) continue;
            
            while(a1[i]-->0 && count<n/2){
                num++;
                count+=i;
            }
        }
        return num;
    }
}