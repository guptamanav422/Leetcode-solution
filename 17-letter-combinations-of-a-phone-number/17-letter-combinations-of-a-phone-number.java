class Solution {
    String arr[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        
        List<String> list=new ArrayList<>();
        
        if(digits.length()==0){
            return list;
        }
        
        List<String> temp=letterCombinations(digits.substring(1));
        for(char ch:arr[digits.charAt(0)-'0'].toCharArray()){
            if(temp.size()==0) list.add(ch+"");
            else{
                for(String str:temp){
                    list.add(ch+str);
                }
            }
        }
        return list;
    }
}