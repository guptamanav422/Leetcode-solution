class Solution {
    public int calculate(String s)
    {
        Stack<Integer> st1=new Stack<>();
        Stack<Character> st2=new Stack<>();
        int ans=0;
        int num=-1;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ') continue;
            else if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                if(num==-1) num=0;
                num=num*10+s.charAt(i)-'0';
            }
            else{
                st1.push(num);
                while(!st2.isEmpty() && find(st2.peek())>=find(s.charAt(i))){
                    st1.push(calc(st1.pop(),st1.pop(),st2.pop()));
                }
                st2.push(s.charAt(i));
                num=-1;
            }
        }
        if(num!=-1) st1.push(num);
        while(!st2.isEmpty()){
             st1.push(calc(st1.pop(),st1.pop(),st2.pop()));
         }
        return st1.peek();
    }
    int calc(int b,int a,char ch){
        if(ch=='+') return a+b;
        else if(ch=='-') return a-b;
        else if(ch=='*') return a*b;
        else return a/b;
    }
    public int find(char a){
        if(a=='+' || a=='-') return 1;
        return 2;
    }
}