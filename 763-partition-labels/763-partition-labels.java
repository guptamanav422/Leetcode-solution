class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> ans=new ArrayList<>();
        
        int hash[]=new int[26];
        for(char ch:s.toCharArray()){
            hash[ch-'a']++;
        }
        
        int c=0;
        int arr[]=new int[26];
        for(char ch:s.toCharArray()){
            
            c++;
            hash[ch-'a']--;
            arr[ch-'a']=1;
            if(hash[ch-'a']==0){
                boolean flag=true;
                for(int i=0;i<26;i++){
                    if(arr[i]!=0 && hash[i]!=0){
                        flag=false;
                        break;
                    }
                }
                
                if(flag){
                    ans.add(c);
                    c=0;
                    arr=new int[26];
                }
            }
        }
        if(c!=0) ans.add(c);
        return ans;
    }
}