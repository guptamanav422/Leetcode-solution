class Solution {
    int dp[][];
    public int findRotateSteps(String ring, String key) {
        
        List<Integer> list[]=new ArrayList[26];
        for(int i=0;i<26;i++){
            list[i]=new ArrayList<>();
        }
        int n=ring.length();
        dp=new int[key.length()][n];
        for(int i=0;i<n;i++){
            list[ring.charAt(i)-'a'].add(i);
        }
        return find(0,0,n,key,list)+key.length();
    }
    int find(int i,int pos,int n,String key,List<Integer> list[]){
        if(i==key.length()) return 0;
        
        if(dp[i][pos]!=0) return dp[i][pos];
        int ans=Integer.MAX_VALUE;
        for(int p:list[key.charAt(i)-'a']){
            ans=Math.min(ans,find(i+1,p,n,key,list) + Math.min(Math.abs(p-pos),(n-Math.abs(p-pos))));
        }
        // System.out.println(ans+" "+pos+" "+i);
        return dp[i][pos]=ans;
    }
}