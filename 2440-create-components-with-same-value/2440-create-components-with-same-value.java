class Solution {
    boolean ok=true;
    List<List<Integer>> list=new ArrayList<>();
    public int componentValue(int[] nums, int[][] edges) {
        
        int n=nums.length,sum=0;
        for(int a:nums){
            sum+=a;
        }
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        
        for(int edge[]:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        
        int ans=1;
        for(int i=1;i<=Math.sqrt(sum);i++){
            
            if(sum%i==0){
                ok=true;
                find(0,-1,i,nums);
                if(ok){
                    ans=sum/i;
                    break;
                }
                
                ok=true;
                find(0,-1,sum/i,nums);
                if(ok){
                    ans=i;
                }
                
            }
        }
        return ans-1;
    }
    int find(int i,int p,int sum,int nums[]){
        
        
        int sum1=nums[i];
        for(int a:list.get(i)){
            
            if(a!=p) sum1+=find(a,i,sum,nums);
        }
        
        if(sum1>sum) ok=false;
        return (sum1==sum)?0:sum1;
    }
}