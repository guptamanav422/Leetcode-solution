class Solution {
public:
    vector<int> frequencySort(vector<int>& nums) {
        vector<int> ans;
        map <int,int> mp;
        for(int i=0;i<nums.size();i++)
        {
          mp[nums[i]]++;   
            
        }
        
priority_queue <pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
        for(auto i=mp.begin();i!=mp.end();i++)
        {   
            pq.push(make_pair(i->second,i->first));
        }
        int f;
        priority_queue<pair<int,int>> qq;
        while(pq.size()>0)
        {
            
            if(!qq.empty() && qq.top().second!=pq.top().first){
                
                while(!qq.empty()){
                    
                     f=qq.top().second;
                    for(int i=1;i<=f;i++)
                    ans.push_back(qq.top().first);
                    
                    qq.pop();
                }
            }
            qq.push(make_pair(pq.top().second,pq.top().first));
            pq.pop();
            
        }
        while(!qq.empty()){
                    
             f=qq.top().second;
            for(int i=1;i<=f;i++)
            ans.push_back(qq.top().first);
            qq.pop();
        }
        return ans;
    }
};