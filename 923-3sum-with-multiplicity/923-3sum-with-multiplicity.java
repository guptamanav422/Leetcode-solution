class Solution {
    public int threeSumMulti(int[] arr, int target) {
        
        long ans=0;
        int n=arr.length;
        
        Arrays.sort(arr);
        for(int i=0;i<n-2;i++){
            int j=i+1,k=n-1;
            
            while(j<k){
                
                int sum=arr[i]+arr[j]+arr[k];
                if(sum==target){
                    int c=1,c1=1;
                    while(j<k-1 && arr[j]==arr[j+1]){
                        j++;
                        c++;
                    }
                    while(j<k-1 && arr[k]==arr[k-1]){
                        k--;
                        c1++;
                    }
                    if(arr[k]==arr[j]) ans+=((c)*(c+1))/2;
                    else ans+=(c*c1);
                    j++;
                    k--;
                }
                else if(sum>target) k--;
                else j++;
            }
            // System.out.println(ans);
        }
        return (int)(ans%1000000007);
    }
}