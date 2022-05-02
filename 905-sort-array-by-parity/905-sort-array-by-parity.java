class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int arr[]=new int[5001];
        for(int a:nums)
        {
            arr[a]++;
        }
        int s=0,e=nums.length-1;
        for(int i=0;i<5001;i++)
        {
            if(i%2==0)
            {
                while(arr[i]-->0)
                {
                    nums[s++]=i;
                }
            }
        }
        for(int i=0;i<5001;i++)
        {
            if(i%2!=0)
            {
                while(arr[i]-->0)
                {
                    nums[s++]=i;
                }
            }
        }
        return nums;
    }
}