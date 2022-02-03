// { Driver Code Starts
// C++ implementation of For each element in 1st 
// array count elements less than or equal to it
// in 2nd array
#include <bits/stdc++.h>
 
using namespace std;


 // } Driver Code Ends
// function to count for each element in 1st array,
// elements less than or equal to it in 2nd array
class Solution{
  public:
    vector<int> countEleLessThanOrEqual(int arr1[], int arr2[], 
                                 int m, int n)
    {
        vector<int> arr;
        sort(arr2,arr2+n);
        for(int i=0;i<n;i++){
            arr.push_back(arr2[i]);
        }
        
        vector<int> ans;
        for(int i=0;i<m;i++){
            int idx=lower_bound(arr.begin(),arr.end(),arr1[i])-arr.begin();
            
            while(idx<n && arr[idx]==arr1[i]) idx++;
            ans.push_back((idx==ans.size() || arr[idx]!=arr1[i])?idx:idx+1);
        }
        return ans;
        
    }
};

// { Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int m,n;
        cin>>m>>n;
        int arr1[m],arr2[n];
        for(int i=0;i<m;i++)
        cin>>arr1[i];
        for(int j=0;j<n;j++)
        cin>>arr2[j];
        Solution obj;
        vector <int> res = obj.countEleLessThanOrEqual(arr1, arr2, m, n);
        for (int i = 0; i < res.size (); i++) cout << res[i] << " ";
        
        cout<<endl;
    }
    return 0;
}  // } Driver Code Ends