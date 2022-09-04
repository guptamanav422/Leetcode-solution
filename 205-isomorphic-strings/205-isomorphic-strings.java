class Solution {
    public boolean isIsomorphic(String s, String t) {
        int ans[]=new int[256];
        int ans1[]=new int[256];
        int slen=s.length(),tlen=t.length();
        if(slen!=tlen) return false;
        
        for(int i=0;i<slen;i++){
            
            int sch=s.charAt(i);
            int tch=t.charAt(i);
            
            if(ans1[tch]==0 && ans[sch]==0){
                ans[sch]=tch;
                ans1[tch]=sch;
            }
            else if(ans1[tch]!=sch) return false; 
        }
        return true;
    }
}