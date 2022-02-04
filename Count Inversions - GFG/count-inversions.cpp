// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution{
  public:
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    long long ans=0;
    void merge(long long *arr,long long s,long long m,long long e){
        
        long long temp[e-s+1];
        int i=s,j=m+1,k=0;
        while(i<=m || j<=e){
            if(i>m){
                temp[k++]=arr[j++];
            }
            else if(j>e){
                temp[k++]=arr[i++];
            }
            else{
                if(arr[i]<=arr[j]){
                    temp[k++]=arr[i++];
                }
                else{
                    ans+=(m+1-i);
                    temp[k++]=arr[j++];
                }
            }
        }
        
        // cout<<ans<<" "<<s<<" "<<e<<endl;
        for(int i=s;i<=e;i++){
            arr[i]=temp[i-s];
        }
    }
    void find(long long *arr,long long s,long long e){
        
        if(s>=e) return;
        
        long long mid=(s+e)/2;
        find(arr,s,mid);
        find(arr,mid+1,e);
        merge(arr,s,mid,e);
    }
    long long int inversionCount(long long arr[], long long N)
    {
        find(arr,(long long)0,N-1);
        return ans;
    }

};

// { Driver Code Starts.

int main() {
    
    long long T;
    cin >> T;
    
    while(T--){
        long long N;
        cin >> N;
        
        long long A[N];
        for(long long i = 0;i<N;i++){
            cin >> A[i];
        }
        Solution obj;
        cout << obj.inversionCount(A,N) << endl;
    }
    
    return 0;
}
  // } Driver Code Ends