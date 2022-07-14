class Solution {
    public long wonderfulSubstrings(String word) {
        
        int arr[]=new int[2000];
        
        long ans=0;
        int num=0;
        arr[0]++;
        for(char ch:word.toCharArray()){
            
            num^=1<<(ch-'a');
            ans+=arr[num];
            
            for(int i=0;i<=9;i++){
                ans+=arr[num^(1<<i)];
            }
            arr[num]++;
            
        }
        return ans;
        
    }
}