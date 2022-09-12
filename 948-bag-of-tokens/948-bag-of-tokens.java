class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        
        Arrays.sort(tokens);
        int n=tokens.length;
        int s=0,e=n-1;
        
        int ans=0;
        while(s<=e){
            if(tokens[s]>power && (s==e || ans==0)) break;
            
            if(tokens[s]>power){
                ans--;
                power+=tokens[e--];
            }
            else{
                ans++;
                power-=tokens[s++];
            }
        }
        return ans;
    }
}