class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        
        int arr[]=new int[26];
        for(String str:words2){
            int arr1[]=new int[26];
            for(char ch:str.toCharArray()){
                arr1[ch-'a']++;
            }
            for(int i=0;i<26 ;i++){
                arr[i]=Math.max(arr[i],arr1[i]);
            }
        }
        List<String> list=new ArrayList<>();
        for(String str:words1){
            int temp[]=new int[26];
            for(char ch:str.toCharArray()){
               temp[ch-'a']++;
            }
            boolean ok=true;
            for(int i=0;i<26 && ok;i++){
                if(arr[i]>temp[i]){
                    ok=false;
                    break;
                }
            }
            if(ok) list.add(str);
        }
        return list;
    }
}