class Solution {
public:
    vector<int> arrayChange(vector<int>& nums, vector<vector<int>>& operations) {
        map<int,int> ma;
        int n=nums.size();
        for(int i=0;i<n;i++){
            ma[nums[i]]=i;
        }
        
        for(auto arr:operations){
            int idx=ma[arr[0]];
            nums[idx]=arr[1];
            ma.erase(arr[0]);
            ma[arr[1]]=idx;
        }
        return nums;
    }
};