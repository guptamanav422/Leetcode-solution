class Solution {
public:
    bool canTransform(string st, string tar) {
        int n=tar.length();
        int i=0,j=0;
        while(i<n || j<n){
            
            while(i<n && tar[i]=='X') i++;
            while(j<n && st[j]=='X') j++;
            
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
        return true;
    }
};