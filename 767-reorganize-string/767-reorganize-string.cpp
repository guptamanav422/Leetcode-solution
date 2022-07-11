class Solution {
public:
    string reorganizeString(string s) {
        int arr[26];
        fill(arr,arr+26,0);
        for(int i=0;i<s.length();i++){
            arr[s[i]-'a']++;
        }
        vector<pair<int,int>> vec;
        for(int i=0;i<26;i++){
            if(arr[i]==0) continue;
            
            vec.push_back(make_pair(arr[i],i));
        }
        sort(vec.begin(),vec.end());
        
        int j=0,k=1,n=s.length();
        bool ok=1;
        for(int i=vec.size()-1;i>=0 && ok;i--){
            
            int fre=vec[i].first;
            char ch=(vec[i].second+'a');
            // cout<<i<<" "<<ch<<"\n";
            for(;j<n && fre>0;j+=2,fre--){
                s[j]=ch;
            }
            
            for(;k<n && fre>0;k+=2,fre--){
                s[k]=ch;
                if(s[k]==s[k-1]){
                    ok=0;
                }
            }
        }
        return ok?s:"";
    }
};