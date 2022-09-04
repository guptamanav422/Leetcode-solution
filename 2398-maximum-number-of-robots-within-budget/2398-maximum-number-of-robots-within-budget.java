class Solution {
    long sum[];
    public int maximumRobots(int[] c, int[] r, long budget) {
        
        int n=c.length;
        sum=new long[n];
        for(int i=0;i<n;i++){
            sum[i]=r[i];
            if(i!=0) sum[i]+=sum[i-1];
        }
        
        int ans=0;
        int s=1,e=n;
        
        while(s<=e){
            
            int mid=(s+e)/2;
            if(check(mid,c,budget)){
                ans=mid;
                s=mid+1;
            }
            else e=mid-1;
        }
        return ans;
    }
    boolean check(int mid,int c[],long budget){
        
        Deque<Integer> dq= new LinkedList<Integer>();
        
        for(int i=0;i<c.length;i++){
            
            while(!dq.isEmpty() && c[dq.peekLast()]<=c[i]) dq.removeLast();
            
            while(!dq.isEmpty() && dq.peekFirst()<=(i-mid)) dq.removeFirst();
            
            dq.addLast(i);
            if(i>=(mid-1)){
                
                long a=c[dq.peekFirst()];
                
                long b=sum[i]-((i-mid)>=0?sum[i-mid]:0);
                
                if(budget>=(a+b*(long)mid)) return true;
            }
        }
        return false;
 
    }
    
}