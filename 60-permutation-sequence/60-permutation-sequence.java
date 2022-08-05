class Solution {
    public String getPermutation(int n, int k)
    {
        if(n==1) return "1";
        StringBuffer sb=new StringBuffer();
        List<Integer> list=new LinkedList<>();
        int f=fact(n-1);
        for(int i=1;i<=n;i++)
        {
            list.add(i);
        }
        int ab=n-1;
        while(true)
        {
            int ind=(k-1)/(f);
            sb.append(list.get(ind));
            list.remove(ind);
            if(ab==0) break;
            k=k-ind*f;
            f=f/ab;
            ab--;
        }
        return sb.toString();
        
    }
    int fact(int n)
    {
        if(n==0 || n==1) return 1;
        return n*fact(n-1);
    }
}