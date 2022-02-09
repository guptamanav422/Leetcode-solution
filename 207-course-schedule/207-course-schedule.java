class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int indegree[]=new int[numCourses];
        for(int a[]:prerequisites){
            int s=a[0];
            int e=a[1];
            
            indegree[e]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int a[]:prerequisites){
            
            int s=a[0];
            int e=a[1];
            graph.get(s).add(e);
        }
        
        int c=0;
        while(!q.isEmpty()){
            int m=q.remove();
            c++;
            
            for(int a:graph.get(m)){
                if(--indegree[a]==0) q.add(a);
            }
        }
        return c==numCourses;
    }
}

