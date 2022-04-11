class Solution {
    public boolean makesquare(int[] arr) {
        
        
        int sum=0;
        for(int a:arr){
            sum+=a;
        }
        return (sum%4==0) && check(arr,0,0,0,new ArrayList<Integer>(),new ArrayList<Integer>());
    }
    boolean check(int arr[],int i,int a,int b,List<Integer> l1,List<Integer> l2){
        
        if(i==arr.length){
            return a==b && check2(0,0,0,l1) && check2(0,0,0,l2);
        }
        
        l1.add(arr[i]);
        if(check(arr,i+1,a+arr[i],b,l1,l2)) return true;
        l1.remove(l1.size()-1);
        
        l2.add(arr[i]);
        if(check(arr,i+1,a,b+arr[i],l1,l2)) return true;
        l2.remove(l2.size()-1);
        return false;
    }
    boolean check2(int i,int a,int b,List<Integer> list){
        if(list.size()==i) return a==b;
        
        return check2(i+1,a+list.get(i),b,list) || check2(i+1,a,b+list.get(i),list);
    }
}