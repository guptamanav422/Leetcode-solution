class Solution {
    public int calPoints(String[] ops) {
        List<Integer> list=new ArrayList<>();
        for(String str:ops){
            if(str.equals("D")) list.add(2*list.get(list.size()-1));
            else if(str.equals("+")) list.add(list.get(list.size()-1)+list.get(list.size()-2));
            else if(str.equals("C")) list.remove(list.size()-1);
            else list.add(Integer.parseInt(str));
        }
        int ans=0;
        for(int a:list) ans+=a;
        return ans;
    }
}