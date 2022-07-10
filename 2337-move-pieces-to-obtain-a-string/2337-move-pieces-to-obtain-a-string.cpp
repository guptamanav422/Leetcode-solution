class Solution {
public:
    bool canChange(string st, string tar) {
        int n=tar.length(),m=st.length();
        if(n!=m) return false;
    
        int a=0,b=0,i=0,j=0;
        while(i<n && j<n){
            
            while(i<n && tar[i]=='_') i++;
            while(j<n && st[j]=='_') j++;
            
            if(i==n || j==n){
                return i==n && j==n;
            }
            
            if(tar[i]!=st[j]) return false;
            
            if(tar[i]=='L'){
                if(j<i) return false;
            }
            else{
                if(i<j) return false;
            }
            
            i++;
            j++;
        }
        while(i<n && tar[i]=='_') i++;
        while(j<n && st[j]=='_') j++;
        return i==n && j==n;
    }
};