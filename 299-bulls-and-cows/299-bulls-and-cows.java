class Solution {
    public String getHint(String secret, String guess) {
        
        int n=secret.length();
        int a1[]=new int[10],b1[]=new int[10];
        int x=0,y=0;
        for(int i=0;i<n;i++){
            
            if(secret.charAt(i)==guess.charAt(i)) x++;
            else {
                a1[secret.charAt(i)-'0']++;
                b1[guess.charAt(i)-'0']++;
            }
        }
        for(int i=0;i<=9;i++){
            y+=Math.min(a1[i],b1[i]);
        }
        return x+"A"+y+"B";
    }
}