class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n=nums.length;
        int num1=Integer.MIN_VALUE,num2=Integer.MIN_VALUE;
        int count1=0,count2=0;
        
        for(int a:nums){
            if(num1==a){
                num1=a;
                count1++;
            }
            else if(num2==a){
                num2=a;
                count2++;
            }
            else if(count1==0){
                count1=1;
                num1=a;
            }
            else if(count2==0){
                count2=1;
                num2=a;
            }
            else{
                count1--;
                count2--;
            }
        }
        // System.out.println(num1+" "+num2);
        
        count1=0;
        count2=0;
        
        for(int a:nums){
            if(a==num1) count1++;
            if(a==num2) count2++;
        }
        
        List<Integer> list=new ArrayList<>();
        if(count1>(n/3)) list.add(num1);
        if(count2>(n/3)) list.add(num2);
        
        return list;
    }
}