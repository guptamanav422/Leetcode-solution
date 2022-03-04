class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        List<Double> list=new ArrayList<>();
        list.add((double)poured);
        
        for(int i=1;i<=query_row;i++){
           List<Double> temp=new ArrayList<>();
            
            temp.add(Math.max(0,(double)(list.get(0)-1)/(double)2));
            for(int j=0;j<i-1;j++){
                temp.add(Math.max(0,(double)(list.get(j)-1)/(double)2) + Math.max(0,(double)(list.get(j+1)-1)/(double)2));
            }
            temp.add(Math.max(0,(double)(list.get(list.size()-1)-1)/(double)2));
            list=temp;
        }
        return Math.min(1,list.get(query_glass));
    }
}