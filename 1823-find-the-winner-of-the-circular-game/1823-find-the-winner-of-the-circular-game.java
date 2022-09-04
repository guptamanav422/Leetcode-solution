class Solution {
    public int findTheWinner(int n, int k) {
        
        return find(n-1,k)+1;
    }
    int find(int n,int k){
        
        if(n==0) return 0;
        return (find(n-1,k) + k)%(n+1);
        
    }
}