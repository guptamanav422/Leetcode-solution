class Solution {
public:
    int maximumProduct(vector<int>& nums, int k) {
        priority_queue<int, vector<int>, greater<int>> pq;
        long long ans=1, MOD = 1e9+7;
        if(nums.size()==1){
            ans=(k+nums[0])%MOD;
            return ans;
        }
        for(auto ele:nums) pq.push(ele);
        while(k) {
            int x = pq.top(); pq.pop();
            int y=pq.top(); pq.pop();
            int diff=min(k,y-x+1);
            x+=diff;
            k-=diff;
            pq.push(x);
            pq.push(y);
        }
        while(!pq.empty()) {
            int x = pq.top(); pq.pop();
            ans = (ans*x)%MOD;
        }
        return ans;
    }
};