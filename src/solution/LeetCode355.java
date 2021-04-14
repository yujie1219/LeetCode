package solution;

import java.util.*;

public class LeetCode355 {
    class Twitter {
        List<Tweet> tweets;
        Map<Integer, List<Integer>> followsMap;

        /**
         * Initialize your data structure here.
         */
        public Twitter() {
            this.tweets = new ArrayList<>();
            this.followsMap = new HashMap<>();
        }

        /**
         * Compose a new tweet.
         */
        public void postTweet(int userId, int tweetId) {
            tweets.add(new Tweet(userId, tweetId));
        }

        /**
         * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
         */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> followees = new ArrayList<>();
            if (followsMap.containsKey(userId)) {
                followees = followsMap.get(userId);
            }

            List<Integer> result = new ArrayList<>();
            for (int i = tweets.size() - 1; i >= 0; i--) {
                Tweet tweet = tweets.get(i);
                if (tweet.userId == userId || followees.contains(tweet.userId)) {
                    result.add(tweet.tweetId);
                }

                if (result.size() == 10) {
                    break;
                }
            }

            return result;
        }

        /**
         * Follower follows a followee. If the operation is invalid, it should be a no-op.
         */
        public void follow(int followerId, int followeeId) {
            if (!followsMap.containsKey(followerId)) {
                followsMap.put(followerId, new ArrayList<>());
            }
            followsMap.get(followerId).add(followeeId);
        }

        /**
         * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
         */
        public void unfollow(int followerId, int followeeId) {
            if (followsMap.containsKey(followerId))
                followsMap.get(followerId).remove((Object) followeeId);
        }
    }

    private class Tweet {
        int userId;
        int tweetId;

        public Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }
}
