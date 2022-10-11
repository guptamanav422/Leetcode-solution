class Solution {
    public boolean increasingTriplet(int[] nums)
    {
        Integer a=null,b=null,c=null;
        for(int num:nums)
        {
            if(a==null || a>=num){
                a=num;
            }
            else if(b==null || b>=num){
                b=num;
            }
            else return true;
        }
        return false;
    }
}