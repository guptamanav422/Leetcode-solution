class Solution {
public:
    
    bool check(int val , vector<int>&p){
       
        for(auto i : p){
            if(i%val!=0) return false;
        }
        return true;
        
    }
    
    int minOperations(vector<int>& nums, vector<int>& numsDivide) {
        unordered_map<int,int>m;
        for(auto i : nums){
            m[i]++;
        }
        priority_queue <int, vector<int>, greater<int>> pq;
        for(auto i : m){
            pq.push(i.first);
        }
        int c = 0;
        
        while(!pq.empty()){
            int x = pq.top();
            pq.pop();
            if(check(x , numsDivide)){
                return c;
            }else{
                c+=m[x];
            }
        }
        return -1;
        
        // int s = 0 , e = nums.size();
        // int ans = INT_MAX;
        // while(s<=e){
        //     int mid = s+(e-s)/2;
        //     if(check(mid, nums , numsDivide)){
        //         ans = min(ans , mid);
        //         cout<<mid<<"\n";
        //         e = mid-1;
        //     }else{
        //         s = mid+1;
        //     }
        // }
        // return ans == INT_MAX ? -1 : ans;
    }
};