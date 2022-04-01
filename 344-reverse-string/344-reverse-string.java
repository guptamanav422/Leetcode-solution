class Solution {
    public void reverseString(char[] str) {
        int s=0,e=str.length-1;
        while(s<e){
            char temp=str[s];
            str[s]=str[e];
            str[e]=temp;
            s++;
            e--;
        }
    }
}