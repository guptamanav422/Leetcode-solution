class Solution {
    public int threeSumClosest(int[] arr, int target)
    {
        Arrays.sort(arr);
        int n=arr.length;
        int ans=0,closest=100000;
        for(int i=0;i<n-2;i++)
        {
            int j=i+1;
            int k=n-1;
            while(j<k)
            {
                int sum=arr[i]+arr[j]+arr[k];
                if(Math.abs(target-sum)<closest)
                {
                    closest=Math.abs(target-sum);
                    ans=sum;
                }
                if(sum>target) k--;
                else j++;
                // if(j<k && arr[j]==arr[j+1]) j++;
                // if(j<k && arr[k]==arr[k-1]) k--;
            }
        }
        return ans;
    }
}