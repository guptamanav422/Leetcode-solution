class Solution {
    public String fractionToDecimal(int n1, int d1) {
        
        if(n1==0) return "0";
        StringBuilder sb=new StringBuilder();
        sb.append(((n1 > 0) ^ (d1 > 0)) ? "-" : "");
        long n=Math.abs((long)n1),d=Math.abs((long)d1);
        sb.append(n/d);
        n=n%d;
        if(n!=0){
            sb.append(".");
            int ind=sb.length();
            Map<Long,Integer> map=new HashMap<>();
            map.put(n,ind);
            while(n!=0){
                n=n*10;
                sb.append(n/d);
                n=n%d;
                if(map.containsKey(n)){
                    int ii=map.get(n);
                    sb.insert(ii,'(');
                    sb.append(")");
                    break;
                }
                ind++;
                map.put(n,ind);
            }
        }
        return sb.toString();
    }
}