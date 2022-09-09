class Solution {
    public int numberOfWeakCharacters(int[][] arr) {
        
        Arrays.sort(arr,(int a[],int b[])->(a[0]==b[0])?(a[1]-b[1]):(a[0]-b[0]));
        
        int n=arr.length,ans=0;
        PriorityQueue<int []> pq=new PriorityQueue<>((int a[],int b[])->(a[1]==b[1])?(a[0]-b[0]):(a[1]-b[1]));
        PriorityQueue<int []> temp=new PriorityQueue<>((int a[],int b[])->(a[1]==b[1])?(a[0]-b[0]):(a[1]-b[1]));
        pq.add(arr[0]);
        for(int i=1;i<n;i++){
            
            if(temp.size()!=0 && temp.peek()[0]!=arr[i][0]){
                pq.addAll(temp);
                temp=new PriorityQueue<>((int a[],int b[])->(a[1]==b[1])?(a[0]-b[0]):(a[1]-b[1]));
            }
            while(!pq.isEmpty() && arr[i][1]>pq.peek()[1]){
                ans++;
                pq.remove();
            }
            
             temp.add(arr[i]);
        }
        return ans;
    }
}