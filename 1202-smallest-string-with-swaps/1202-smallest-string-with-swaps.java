class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n=s.length();
        int par[]=new int[n];
        Map<Integer,int []> map1=new HashMap<>();
        for(int i=0;i<n;i++){
            par[i]=i;
        }        
        for(List<Integer> aa:pairs){
            int a=find(aa.get(0),par);
            int b=find(aa.get(1),par);
            
            par[b]=a;
        }
        
        for(int i=0;i<n;i++){
            
            int pa=find(par[i],par);
            if(!map1.containsKey(pa)){
                map1.put(pa,new int[26]);
            }
            map1.get(pa)[s.charAt(i)-'a']++;
        }
        
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<n;j++){
            int temp[]=map1.get(find(j,par));
            
            for(int i=0;i<26;i++){
                if(temp[i]!=0){
                    temp[i]--;
                    sb.append((char)(i+'a'));
                    break;
                }
            }
        }
        return sb.toString();
    }
    int find(int a,int par[]){
        if(a==par[a]) return a;
        return par[a]=find(par[a],par);
    }
}