class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList)
    {
        Map<String,ArrayList<String>> map=new HashMap<>();
        Map<String,Boolean> visit=new HashMap<>();
        for(String str:wordList)
        {
            map.put(str,new ArrayList<>());
            visit.put(str,false);
        }
        map.put(beginWord,new ArrayList<>());
        visit.put(beginWord,false);
        int n=wordList.size();
        for(int i=0;i<n;i++)
        {
            String s1=wordList.get(i);
            for(int j=i+1;j<=n;j++)
            {
                String s2=j==n?beginWord:wordList.get(j);
                if(matches(s1,s2))
                {
                    map.get(s1).add(s2);
                    map.get(s2).add(s1);
                }
            }
        }
        return shortestPath(map,beginWord,endWord,visit);
    }
    int shortestPath(Map<String,ArrayList<String>> graph,String src,String dest,Map<String,Boolean> visit)
    {
        Queue<String> q=new LinkedList<>();
        q.add(src);
        int c=1;
        visit.put(src,true);
        while(!q.isEmpty())
        {
            int s=q.size();
            while(s-->0)
            {
                String a=q.remove();
                if(a.equals(dest)) return c;
                for(String temp:graph.get(a))
                {
                    if(!visit.get(temp))
                    {
                        visit.put(temp,true);
                        q.add(temp);
                    }
                }
            }
            c++;
        }
        return 0;
    }
    boolean matches(String a,String b)
    {
        int len=a.length();
        int c=0;
        for(int i=0;i<len;i++)
        {
            if(a.charAt(i)!=b.charAt(i)) c++;
            if(c>=2) return false;
        }
        return c==1;
    }
}