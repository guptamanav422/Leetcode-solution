class Solution {
    public List<List<String>> groupAnagrams(String[] strs)
    {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs)
        {
            int arr[]=new int[26];
            for(char ch:str.toCharArray()){
                arr[ch-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<26;i++){
                if(arr[i]!=0){
                    sb.append((char)(i+'a')+""+arr[i]);
                }
            }
            String s=sb.toString();
            map.putIfAbsent(s,new ArrayList());
            map.get(s).add(str);
        }
        return new ArrayList(map.values());
    }
}