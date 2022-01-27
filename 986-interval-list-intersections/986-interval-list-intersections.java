class Solution {
    public int[][] intervalIntersection(int[][] arr1, int[][] arr2) {
        
        List<int []> list=new ArrayList<>();
        
        int i=0,j=0,n=arr1.length,m=arr2.length;
        
        while(i<n && j<m){
            
            int min=Math.max(arr1[i][0],arr2[j][0]);
            int max=Math.min(arr1[i][1],arr2[j][1]);
            
            if(min<=max) list.add(new int[]{min,max});
            if(arr1[i][1]>arr2[j][1]) j++;
            else i++;
        }
        return list.toArray(new int[list.size()][]);
    }
}