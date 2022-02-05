class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int tar) {
        
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<=9;i++){
            for(int j=0;j<=9;j++){
                
                int h=i*10+j;
                for(int k=0;k<=9;k++){
                    for(int l=0;l<=9;l++){
                        
                        int m=(k*10)+l;
                    
                        if((h*60 + m)==tar){
                            List<Integer> list=new ArrayList<>();
                            if(i!=0){
                                list.add(i);
                                list.add(j);
                                list.add(k);
                                list.add(l);
                            }
                            else if(j!=0){
                                list.add(j);
                                list.add(k);
                                list.add(l);
                            }
                            else if(k!=0){
                                list.add(k);
                                list.add(l);
                            }
                            else list.add(l);
                            
                            ans=Math.min(ans,find(list,startAt,moveCost,pushCost));
                        }
                    }
                }
            }
        }
        return ans;
    }
    int find(List<Integer> arr,int st,int move,int push){
        int ans=0;
        for(int a:arr){
            if(st==a) ans+=push;
            else ans+=move+push;
            st=a;
        }
        return ans;
    }
}