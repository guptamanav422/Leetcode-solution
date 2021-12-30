class Solution {
    public int smallestRepunitDivByK(int k) {
        
        Set<Integer> set=new HashSet<>();
        int num=1,len=1;
        while(true){
            
            if(num%k==0) return len;
            len++;
            num=num%k;
            if(set.contains(num)) return -1;
            set.add(num);
            num=(num*10)+1;
        }
    }
}