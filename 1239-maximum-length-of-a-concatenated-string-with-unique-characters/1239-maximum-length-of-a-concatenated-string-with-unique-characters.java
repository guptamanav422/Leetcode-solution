class Solution {
    
    int ans=0;
    public int maxLength(List<String> arr) {
        
        boolean vis[]=new boolean[26];
        
        find(arr,0,vis);
        return ans;
    }
    void find(List<String> arr,int i,boolean vis[]){
        if(i==arr.size()){
            
            int count=0;
            for(boolean a:vis){
                if(a) count++;
            }
            ans=Math.max(ans,count);
            return;
        }
        
        boolean vis1[]=vis.clone();
        boolean ok=true;
        for(char ch:arr.get(i).toCharArray()){
            
            if(vis1[ch-'a']){
                ok=false;
                break;
            }
            
            vis1[ch-'a']=true;
        }
        
        if(ok) find(arr,i+1,vis1);
        find(arr,i+1,vis);
        
    }
}