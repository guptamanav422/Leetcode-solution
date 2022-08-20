class Solution {
    public long[] maximumSegmentSum(int[] nums, int[] quer) {       
        int n=nums.length;
        PriorityQueue<long []> pq=new PriorityQueue<>((long a[],long b[])->(a[2]<=b[2])?1:-1);  
        TreeSet<Integer> set=new TreeSet<>();
        long arr[]=new long[n],ans[]=new long[n];
        set.add(-1);
        set.add(n);
        for(int i=0;i<n;i++){
            arr[i]=nums[i];
            if(i!=0) arr[i]+=arr[i-1];
        }
        pq.add(new long[]{0,n-1,arr[n-1]});
        
        for(int i=0;i<n;i++){
            int num=quer[i];
            set.add(quer[i]);
            int a=set.lower(num), b=set.higher(num);
            
            if((a+1)<num){
                pq.add(new long[]{(long)a+1,(long)num-1,arr[num-1]-(long)((a==-1)?0:arr[a])});
            }
            if((num+1)<b){
                pq.add(new long[]{(long)num+1,(long)b-1,arr[b-1]-arr[num]});
            } 
            while(!pq.isEmpty()){
                long ab[]=pq.peek();
                int s=(int) ab[0],e=(int) ab[1];

                if(set.higher(s-1)>e){
                    ans[i]=pq.peek()[2];
                    break;
                }
                else pq.remove();
            }
            
        }
        return ans;
    }
}