class Solution {
    public int findComplement(int num) {
        
        int ans=0;
        String temp="";
        while(num!=0){
            if(num%2==0) temp+=1;
            else temp+="0";
            num=num/2;
        }
        for(int i=temp.length()-1;i>=0;i--){
            ans=ans*2 + (temp.charAt(i)-'0');
        }
        return ans;
    }
}