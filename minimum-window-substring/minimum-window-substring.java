class Solution {
    public String minWindow(String s, String t)
    {
        int arr1[]=new int[125];
        int arr2[]=new int[125];
        int n=s.length(),m=t.length(),ans=Integer.MAX_VALUE;
        int c1=0,c2=0;
        int si=0,ei=1000000;
        for(char ch:t.toCharArray())
        {
            arr1[ch]++;
            if(arr1[ch]==1) c1++;
        }
        int prev=0;
        for(int i=0;i<n;){
            
            int j=prev;
            while(i<n && c1>c2){
                char ch=s.charAt(i);
                arr2[ch]++;
                
                if(arr2[ch]==arr1[ch]) c2++;
                i++;
            }
            
            if(c1>c2) break;
            while(true){
                char ch=s.charAt(j);
                if(arr1[ch]==arr2[ch]) break;
                
                arr2[ch]--;
                j++;
            }
            
            if((i-j)<(ei-si)){
                ei=i;
                si=j;
            }
            
            c2--;
            arr2[s.charAt(j)]--;
            j++;
            prev=j;
            
            // System.out.println(si+" "+ei);
        }
        if(ei==1000000) return "";
        return s.substring(si,ei);
    }
}