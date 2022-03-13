class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        
        map <int,int> mp;
        vector<int> ams;
        
        for(auto a:nums)
        {
            mp[a]=mp[a]+1;
            
        }
        // for(auto i:mp){
        //     cout<<i.first<<" "<<i.second<<endl;
        // }
        
        priority_queue <pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
        for(auto i:mp)
        {
            pq.push(make_pair(i.second,i.first));
            
            if(pq.size()>k) pq.pop();
        }
        
        while(pq.size()>0)
        {
            
            ams.push_back(pq.top().second);
            pq.pop();
        } 
    
    return ams;
    }
};