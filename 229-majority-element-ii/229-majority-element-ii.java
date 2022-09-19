class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        
        int a=Integer.MAX_VALUE,b=Integer.MAX_VALUE,m1=0,m2=0,n=nums.length;
        
        for(int num:nums){
            if(num==a) m1++;
            else if(num==b) m2++;
            else if(a==Integer.MAX_VALUE || m1==0){
                a=num;
                m1=1;
            }
            else if(b==Integer.MAX_VALUE || m2==0){
                b=num;
                m2=1;
            }
            else{
                m1--;
                m2--;
            }
        }
        
        m1=m2=0;
        for(int num:nums){
            if(num==a) m1++;
            else if(num==b) m2++;
        }
        List<Integer> ans=new ArrayList<>();
        if(m1>n/3) ans.add(a);
        if(m2>n/3) ans.add(b);
        return ans;
    }
}