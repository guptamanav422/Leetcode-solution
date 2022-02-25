class Solution {
    public int compareVersion(String version1, String version2) {
        
        String str1[]=version1.split("\\."),str2[]=version2.split("\\.");
        int max=Math.max(str1.length,str2.length);
        
        // System.out.println(max);
        for(int i=0;i<max;i++){
            int a=i<str1.length?Integer.parseInt(str1[i]):0;
            int b=i<str2.length?Integer.parseInt(str2[i]):0;
            
            // System.out.println(a+" "+b);
            if(a!=b){
                return a>b?1:-1;
            }
        }
        return 0;
    }
}