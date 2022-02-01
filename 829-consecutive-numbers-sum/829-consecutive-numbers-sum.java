class Solution {
    public int consecutiveNumbersSum(int n) {
        
        int sum=0,i=1,c=0;
        for(;sum<n;i++){
            sum+=i;
        }
        i--;
        for(int k=1;k<=i;k++){
            
            if((n-(k*(k-1)/2))%k==0){
                // System.out.println(k);
                c++;
            }
        }
        return c;
    }
}