class Solution {
    public long maximumBeauty(int[] flowers, long left, int target, int full, int partial) {
        
        Arrays.sort(flowers);
        int n=flowers.length;
        long arr[]=new long[n];
        if(flowers[0]>=target){
            return (long)n*(long)full;
        }
        int c1=0;
        // arr[0]=flowers[0];
        for(int i=1;i<n;i++){
            flowers[i]=Math.min(target,flowers[i]);
            arr[i]=arr[i-1]+(flowers[i]-flowers[i-1])*i;
        }
        // System.out.println(left+" "+arr[n-1]);
        if(left>=arr[n-1] + (target-flowers[n-1])*n){
            return Math.max((long)n*(long)full, (long)(n-1)*(long)full + ((long)target-1)*(long)partial);
        }
        // System.out.println("hello");
        int j=n-1;
        while(flowers[j]==target) j--;
        long ans=(n-j-1)*full + (long)flowers[0]*(long)partial;
        while(left>=0){
            
            int idx=Arrays.binarySearch(arr,left);
            if(idx<0) idx=-(idx+2);
            
            idx=Math.min(idx,j);
            
            long num=flowers[idx] + ((left-arr[idx])/(idx+1));
            ans=Math.max(ans,(num)*((long)partial) + (long)(n-1-j)*(long)full);
            
            // System.out.println(left+" "+idx+" "+ans);
            left-=(target-flowers[j]);
            flowers[j]=target;
            j--;
        }
        return ans;
        
    }
}