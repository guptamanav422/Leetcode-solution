class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(int a[],int b[])-> a[1]-b[1]);
        PriorityQueue < Integer > pq = new PriorityQueue < > ((a, b) -> b - a);
        
        int st=0;
        for(int arr[]:courses){
            
            if(st+arr[0]<=arr[1]){
                pq.add(arr[0]);
                st+=arr[0];
            }
            else if(!pq.isEmpty() && pq.peek()>arr[0]){
                st+=-pq.remove()+arr[0];
                pq.add(arr[0]);
            }
        }
        return pq.size();
    }
}