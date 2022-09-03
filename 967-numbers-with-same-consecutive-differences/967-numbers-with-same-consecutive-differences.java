class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
        List<Integer> list=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=9;i++){
            q.add(i);
        }
        
        int size=1;
        while(!q.isEmpty()){
            
            int Qsize=q.size();
            while(Qsize-->0){
                
                int num=q.remove();
                
                if(size==n){
                    list.add(num);
                    continue;
                }
                
                int lastDigitOfNum=num%10;
                if(lastDigitOfNum>=k){
                    q.add(num*10+lastDigitOfNum-k);
                }
                if((lastDigitOfNum+k)<=9 && k!=0){
                    q.add(num*10+lastDigitOfNum+k);
                }
            }
            size++;
        }
        int arr[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}