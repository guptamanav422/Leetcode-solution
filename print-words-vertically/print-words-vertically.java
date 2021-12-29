class Solution {
    public List<String> printVertically(String str) {
        
        List<String> ans=new ArrayList<>();
        String arr[]=str.split(" ");
        int len=1;
        for(int i=0;i<len;i++){
            StringBuilder sb=new StringBuilder();
            for(String s:arr){
                
                if(i==0){
                    len=Math.max(len,s.length());
                }
                
                char ch=i>=s.length()?' ':s.charAt(i);
                sb.append(ch);
            }
            ans.add(sb.toString().stripTrailing());
        }
        return ans;
    }
}