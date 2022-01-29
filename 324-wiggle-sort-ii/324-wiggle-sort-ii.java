class Solution {
    public void wiggleSort(int[] nums) {
        
        Arrays.sort(nums);
        
        int n=nums.length;
        int las=1;
        int fir=(n%2==0)?n-2:n-1;
        
        int temp[]=new int[n];
        for(int i=las;i<n;i+=2){
            temp[i]=nums[n-1-i/2];
        }
        int j=0;
        for(int i=fir;i>=0;i-=2){
            temp[i]=nums[j++];
        }
        for(int i=0;i<n;i++) nums[i]=temp[i];
    }
}