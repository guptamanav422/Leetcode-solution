class Solution {
public:
    vector<vector<int>> generate(int n) {
       vector<vector<int>>c;
    // Write your code here.
        for(int i=0;i<n;i++){
            vector<int>a ;
            a.push_back(1);
            for(int j=1;j<i;j++){
                a.push_back(c[i-1][j]+c[i-1][j-1]);
            }
            
            if(i!=0)  a.push_back(1);
            c.push_back(a);  
        }
        return c;  
    }
};