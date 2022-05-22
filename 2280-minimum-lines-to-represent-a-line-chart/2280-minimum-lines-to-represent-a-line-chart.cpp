class Solution {
public:
    int minimumLines(vector<vector<int>>& stockPrices) {
        sort(stockPrices.begin(),stockPrices.end());
        
        int dx=INT_MIN,dy=INT_MIN,ans=0;
        
        for(int i=1;i<stockPrices.size();i++){
            
            int d1x=stockPrices[i][0]-stockPrices[i-1][0], d1y=stockPrices[i][1]-stockPrices[i-1][1];
            
            int g=gcd(d1x,d1y);
           if((d1x/g !=dx) || (d1y/g!=dy)){
               ans++;
               dx=d1x/g;
               dy=d1y/g;
           }
            
        }
        return ans;
    }
};