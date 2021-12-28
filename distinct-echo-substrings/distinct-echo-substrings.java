class Solution {
    public int distinctEchoSubstrings(String text) {
        
        int n=text.length();
        Map<String,Integer> map=new HashMap<>();
        for(int i=1;i<n;i++){
            
            for(int j=0;j<i;j++){
                
                int gap=(i-j+1);
                if(gap%2==0 && text.substring(j,j+gap/2).equals(text.substring(j+gap/2,i+1))){
                    map.put(text.substring(j,i+1),0);
                }
            }
        }
        return map.size();
    }
}