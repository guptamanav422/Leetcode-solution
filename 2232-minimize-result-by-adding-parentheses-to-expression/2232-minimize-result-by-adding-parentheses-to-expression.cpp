class Solution {
public:
    string minimizeResult(string str) {
        
        int n=str.length();
        
        int idx=0;
        while(idx<n && str[idx]!='+') idx++;
        idx++;
        int ans=1000000000;
        string res="";
        for(int i=0;i<idx-1;i++){
            for(int j=idx;j<n;j++){
                string sb=str.substr(0,i) + "(" + str.substr(i,j+1-i) + ")" +str.substr(j+1,n);
                
                int a=0,b=0,c=0,d=0,k=0;
                for(;sb[k]!='(';k++){
                    a=a*10+(sb[k]-'0');
                }
                k++;
                for(;sb[k]!='+';k++){
                    b=b*10+(sb[k]-'0');
                }
                k++;
                for(;sb[k]!=')';k++){
                    c=c*10+(sb[k]-'0');
                }
                k++;
                for(;k<sb.length();k++){
                    d=d*10+(sb[k]-'0');
                }
                b=b+c;
                if(a==0) a=1;
                if(d==0) d=1;
                
                int abc=a*b*d;
                if(abc<ans){
                    res=sb;
                    ans=abc;
                }
            }
        }
        return res;
    }
};