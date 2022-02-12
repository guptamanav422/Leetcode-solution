class Solution {
    class Node{
        Node children[];
        boolean isLast;
        Node(){
            children=new Node[26];
            isLast=false;
        }
    }
    Node tree=new Node();
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String str:dictionary){
            add(str);
        }
        
        String arr[]=sentence.split(" ");
        StringBuffer sb=new StringBuffer();
        int i=0;
        for(String str:arr){
            String temp=search(str);
            if(temp.equals("")) arr[i]=str;
            else arr[i]=temp;
            i++;
        }
        return String.join(" ",arr);
    }
    String search(String str){
        
        Node root=tree;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(root.children[ch-'a']==null) return "";
            root=root.children[ch-'a'];
            if(root.isLast) return str.substring(0,i+1);
        }
        return "";
    }
    void add(String str){
        Node root=tree;
        
        for(char ch:str.toCharArray()){
            if(root.children[ch-'a']==null){
                root.children[ch-'a']=new Node();
            }
            root=root.children[ch-'a'];
        }
        root.isLast=true;
    }
}