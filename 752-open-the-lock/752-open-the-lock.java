class Solution {
    public int openLock(String[] deadends, String tar) {
        
        Queue<int []> q=new LinkedList<>();
        boolean vis[]=new boolean[10000];
        
        for(String str:deadends){
            int num=0;
            for(char ch:str.toCharArray()){
                num=num*10 + (ch-'0');
            }
            // System.out.println(num);
            vis[num]=true;
        }
        
        q.add(new int[]{0,0,0,0});
        
        int ans=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                
                int arr[]=q.remove();
                int num=arr[0]*1000+arr[1]*100 +arr[2]*10+arr[3];
                if(vis[num]) continue;
                
                // System.out.println(num+" "+ans);
                vis[num]=true;
                if(arr[0]==tar.charAt(0)-'0' && arr[1]==tar.charAt(1)-'0' && arr[2]==tar.charAt(2)-'0' && arr[3]==tar.charAt(3)-'0') return ans;
                
                for(int i=0;i<4;i++){
                    arr[i]=(arr[i]+1)%10;
                    num=arr[0]*1000+arr[1]*100 +arr[2]*10+arr[3];
                    if(!vis[num]) q.add(Arrays.copyOf(arr,4));
                    num=arr[0]*1000+arr[1]*100 +arr[2]*10+arr[3];
                    if(!vis[num]) q.add(Arrays.copyOf(arr,4));
                    arr[i]=(arr[i]-2+10)%10;
                    q.add(Arrays.copyOf(arr,4));
                    
                    arr[i]=(arr[i]+1)%10;
                }
            }
            ans++;
        }
        return -1;
    }
}