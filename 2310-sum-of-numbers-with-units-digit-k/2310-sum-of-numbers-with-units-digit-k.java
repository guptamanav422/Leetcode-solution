class Solution {
    public int minimumNumbers(int num, int k) {
        
        if(num==0) return 0;
        int c=0,i=1;
        for(;i*k<num && i<=10 && ((i*k)%10!=(num%10));i++);
        
        return (i*k<=num && i<=10)?i:-1;
    }
}