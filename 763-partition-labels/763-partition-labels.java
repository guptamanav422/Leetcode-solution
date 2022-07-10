class Solution {
    public List<Integer> partitionLabels(String s) {
        
        List<Integer> ans=new ArrayList<>();
        
        int hash[]=new int[26],n=s.length();
        for(int i=0;i<n;i++){
            hash[s.charAt(i)-'a']=i;
        }
        
        int max=0,p=-1;
        for(int i=0;i<n;i++){
            max=Math.max(max,hash[s.charAt(i)-'a']);
            if(max==i){
                ans.add(i-p);
                p=i;
            }
        }
        return ans;
    }
}