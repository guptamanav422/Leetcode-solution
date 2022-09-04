class Solution {
      public int maxOperations(int[] nums, int k) {
        
        Arrays.sort(nums);
        int s=0,e=nums.length-1,res=0;
          
          
          while(s<e){
              
              int sum=nums[s]+nums[e];
              if(sum==k){
                  res++;
                  s++;
                  e--;
              }
              else if(sum>k) e--;
              else s++;
          }
        return res;
    }
}