// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++

class Solution{   
public:
    int getMinDiff(int arr[], int n, int k) {
        vector<pair<int,int>> vec;
        
        for(int i=0;i<n;i++){
            vec.push_back(make_pair(arr[i]-k,i));
            vec.push_back(make_pair(arr[i]+k,i));
        }
        
        sort(vec.begin(),vec.end());
        int visit[n];
        fill(visit,visit+n,0);
        int s=0,e=0,c=0,ans=vec[vec.size()-1].first-vec[0].first;
        while(e<2*n){
            
            while(e<2*n && c<n){
                pair<int,int> temp=vec[e];
                int num=temp.first;
                int idx=temp.second;
                if(visit[idx]==0){
                    c++;
                }
                visit[idx]++;
                e++;
            }
            if(c<n) break;
            while(c==n){
                pair<int,int> temp=vec[s];
                int num=temp.first;
                int idx=temp.second;
                visit[idx]--;
                if(visit[idx]==0){
                    c--;
                }
                ans=min(ans,vec[e-1].first-vec[s].first);
                s++;
            }
            
            // cout<<s<<" "<<e<<endl;
        }
        return ans;
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> k;
        cin >> n;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.getMinDiff(arr, n, k);
        cout << ans << "\n";
    }
    return 0;
}  // } Driver Code Ends