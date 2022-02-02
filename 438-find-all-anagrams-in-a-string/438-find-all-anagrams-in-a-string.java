class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int count=0,slen=s.length(),plen=p.length();
        if(plen>slen) return ans;
        
        int arr[]=new int[26];
        for(int a:p.toCharArray()){
            arr[a-'a']++;
        }
        
        for(int i=0;i<plen;i++){
            char ch=s.charAt(i);
            if(--arr[ch-'a']==-1) count++;
        }
        if(count==0) ans.add(0);
        for(int i=1;i<=slen-plen;i++){
            char ch=s.charAt(i+plen-1);
            if(--arr[ch-'a']==-1) count++;
            
            ch=s.charAt(i-1);
            if(++arr[ch-'a']==0) count--;
            
            if(count==0) ans.add(i);
        }
        return ans;
    }
}