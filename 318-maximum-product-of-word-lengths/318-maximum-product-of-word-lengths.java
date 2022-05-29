class Solution {
    public int maxProduct(String[] words)
    {
        int n=words.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=find(words[i]);
        }
        
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((arr[i] & arr[j])==0) ans=Math.max(ans,words[i].length() * words[j].length());
            }
        }
        
        return ans;
    }
    int find(String str){
        int ans=0;
        int arr[]=new int[26];
        for(char ch:str.toCharArray()){
            arr[ch-'a']=1;
        }
        
        for(int i=0;i<26;i++){
            if(arr[i]==1) ans+=(int)(Math.pow(2,i));
        }
        return ans;
    }
}