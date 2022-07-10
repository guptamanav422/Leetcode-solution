class Twitter {
    
    Map<Integer,Set<Integer>> map;
    List<int []> list;
    public Twitter() {
        map=new HashMap<>();
        list=new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId)) map.put(userId,new HashSet<>());
        map.get(userId).add(userId);
        list.add(new int[]{userId,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        List<Integer> ans=new ArrayList<>();
        int c=0;
        for(int i=list.size()-1;i>=0 && c<10;i--){
            int arr[]=list.get(i);
            
            if(map.containsKey(userId) && map.get(userId).contains(arr[0])){
                ans.add(arr[1]);
                c++;
            }
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!map.containsKey(followerId)) map.put(followerId,new HashSet<>());
        map.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        map.get(followerId).remove(new Integer(followeeId));
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */