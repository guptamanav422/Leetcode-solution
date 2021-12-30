class Solution {
    int parent[],rank[];
    public boolean gcdSort(int[] nums) {
        
        int n=nums.length;
        int sortedArr[]=nums.clone();
        Arrays.sort(sortedArr);
        parent=new int[sortedArr[n-1]+1];
        rank=new int[sortedArr[n-1]+1];
        
        for(int i=0;i<(sortedArr[n-1]+1);i++){
            parent[i]=i;
        }
        
        int SmallestPrimeFactor[]=sieve(sortedArr[n-1]+1);
        
        for(int i=0;i<n;i++){
            for(int a:smallestCurrent(nums[i],SmallestPrimeFactor)){
                union(nums[i],a);
            }
        }
        
        for(int i=0;i<n;i++){
            if(find(nums[i])!=find(sortedArr[i])) return false;
        }
        return true;
    }
    List<Integer> smallestCurrent(int a,int arr[]){
        
        List<Integer> ans=new ArrayList<>();
        while(a>1){
            int temp=arr[a];
             a/=temp;
            // if((temp*a)<arr.length && arr[temp*a]==temp) continue;
            if(!ans.contains(temp))
            ans.add(temp);
        }
        return ans;
    }
    int find(int a){
        if(parent[a]==a) return a;
        else parent[a]=find(parent[a]);
        
        return parent[a];
    }
    void union(int a,int b){
        a=find(a);
        b=find(b);
        
        if(rank[b]>rank[a]){
            int temp=a;
            a=b;
            b=temp;
        }
        
        if(rank[a]==rank[b]) rank[a]++;
        parent[b]=a;
    }
    int [] sieve(int num){
        int arr[]=new int[num];
        
        for(int i=2;i<num;i++){
            arr[i]=i;
        }
        for(int i=2;i*i<num;i++){
            
            if(arr[i]!=i) continue;
            for(int j=i*i;j<num;j+=i){
                if(arr[j]>i) arr[j]=i;
            }
        }
        return arr;
    }
}