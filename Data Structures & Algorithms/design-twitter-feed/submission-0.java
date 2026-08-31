class Twitter {

    class Tweet{
        int tweetId;
        int time;

        Tweet(int tweetId,int time){
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    HashMap<Integer, List<Tweet>> tweets;
    HashMap<Integer,HashSet<Integer>> followingmapper;
    int time;

    public Twitter() {

        tweets = new HashMap<>();
        followingmapper = new HashMap<>();
        time = 0;
        
    }
    
    public void postTweet(int userId, int tweetId) {

        tweets.putIfAbsent(userId,new ArrayList<>());
        followingmapper.putIfAbsent(userId,new HashSet<>());

        tweets.get(userId).add(new Tweet(tweetId,time++));
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<Tweet> maxHeap =
            new PriorityQueue<>((a, b) -> b.time - a.time);

        if(tweets.containsKey(userId)){
            for(Tweet tweet : tweets.get(userId)){
                maxHeap.offer(tweet);
            }
        }
        if(followingmapper.containsKey(userId)){

            for(int followee : followingmapper.get(userId)){
                for(Tweet tweet : tweets.get(followee)){
                    maxHeap.offer(tweet);
                }
            }
        }

        while(!maxHeap.isEmpty() && result.size() < 10)
        {
            result.add(maxHeap.poll().tweetId);
        }

        return result;
        
    }
    
    public void follow(int followerId, int followeeId) {

        followingmapper.putIfAbsent(followerId,new HashSet<>());
        followingmapper.get(followerId).add(followeeId);

        
    }
    
    public void unfollow(int followerId, int followeeId) {

        if(followingmapper.containsKey(followerId)){
            followingmapper.get(followerId).remove(followeeId);
        }
        
    }
}
