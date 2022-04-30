class Solution
{
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)
    {
        Map<String , Map<String ,Double>> map=new HashMap<>();
        create(equations,values,map);
        
        double ans[]=new double[queries.size()];
        int i=0;
        for(List<String> list:queries)
        {
            ans[i++]=found(list.get(0),list.get(1),map,new HashSet<>());
        }
        return ans;
    }
    double found(String u,String v, Map<String , Map<String ,Double>> map,Set<String> set)
    {
        if(!map.containsKey(u) || !map.containsKey(v)) return -1.0;
        if(map.get(u).containsKey(v)) return map.get(u).get(v);
        
        set.add(u);
        
        for(Map.Entry<String,Double> entry:map.get(u).entrySet())
        {
            if(!set.contains(entry.getKey()))
            {
                double ans=found(entry.getKey(),v,map,set);
                if(ans!=-1.0)
                {
                    return ans*entry.getValue();
                }
            }
        }
        return -1.0;
    }
    void create(List<List<String>> equations, double value[],Map<String , Map<String ,Double>> map)
    {
        int i=0;
        for(List<String> list:equations)
        {
            double val=value[i++];
            String u=list.get(0);
            String v=list.get(1);
            if(!map.containsKey(u)) map.put(u,new HashMap<>());
            map.get(u).put(v,val);
            if(!map.containsKey(v)) map.put(v,new HashMap<>());
            map.get(v).put(u,1/val);
        }
    }
}