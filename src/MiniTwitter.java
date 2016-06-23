import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * Implement a simple twitter. Support the following method: postTweet(user_id,
 * tweet_text). Post a tweet.
 * 
 * getTimeline(user_id). Get the given user's most recently 10 tweets posted by
 * himself, order by timestamp from most recent to least recent.
 * 
 * getNewsFeed(user_id). Get the given user's most recently 10 tweets in his
 * news feed (posted by his friends and himself). Order by timestamp from most
 * recent to least recent.
 * 
 * follow(from_user_id, to_user_id). from_user_id followed to_user_id.
 * unfollow(from_user_id, to_user_id). from_user_id unfollowed to to_user_id.
 */
class Tweet {
	public int id;
	public int user_id;
	public String text;

	public static Tweet create(int user_id, String tweet_text) {
		Tweet tweet = new Tweet();
		tweet.user_id = user_id;
		tweet.text = tweet_text;
		return tweet;
	}

	public String toString() {
		return user_id + " " + text;
	}
}

public class MiniTwitter {

	private Map<Integer, List<Tweet>> tweets;
	private Map<Integer, List<Integer>> follows;

	public String toString() {
		return "tweets:" + tweets + "\r\nfollows:" + follows + "\r\n\r\n";
	}

	public MiniTwitter() {
		tweets = new HashMap<Integer, List<Tweet>>();
		follows = new HashMap<Integer, List<Integer>>();
	}

	public Tweet postTweet(int user_id, String tweet_text) {
		List<Tweet> userTweet = tweets.get(user_id);
		if (userTweet == null)
			tweets.put(user_id, new LinkedList<Tweet>());
		Tweet tweet = Tweet.create(user_id, tweet_text);
		if (tweets.get(user_id).size() >= 10)
			((LinkedList<Tweet>) tweets.get(user_id)).removeLast();
		((LinkedList<Tweet>) tweets.get(user_id)).addFirst(tweet);
		return tweet;
	}

	public List<Tweet> getNewsFeed(int user_id) {
		List<Tweet> news = new LinkedList<Tweet>();
		if (tweets.get(user_id) != null)
			news.addAll(tweets.get(user_id));
		if (follows.get(user_id) != null)
			for (int following : follows.get(user_id)) {
				if (tweets.get(following) != null)
					news.addAll(tweets.get(following));
			}
		Collections.sort(news, new Comparator<Tweet>() {
			@Override
			public int compare(Tweet o1, Tweet o2) {
				return o2.id - o1.id;
			}

		});
		if (news.size() > 10) {
			List<Tweet> tmp = new LinkedList<Tweet>();
			Iterator<Tweet> iter = news.iterator();
			int times = 0;
			while (times++ < 10)
				tmp.add(iter.next());
			news = tmp;
		}
		return news;
	}

	public List<Tweet> getTimeline(int user_id) {
		if (tweets.get(user_id) != null)
			return tweets.get(user_id);
		return new LinkedList<Tweet>();
	}

	public void follow(int from_user_id, int to_user_id) {
		if (follows.get(from_user_id) == null)
			follows.put(from_user_id, new LinkedList<Integer>());
		follows.get(from_user_id).add(to_user_id);

	}

	public void unfollow(int from_user_id, int to_user_id) {
		if (follows.get(from_user_id) != null)
			follows.get(from_user_id).remove((Integer)to_user_id);
	}

	@Test
	public void test() {
		MiniTwitter twitter = new MiniTwitter();
		twitter.getTimeline(9);
		twitter.follow(1, 9);
		twitter.getNewsFeed(4);
		twitter.getTimeline(9);
		twitter.postTweet(5, "lmnlintcodelintcodelintco");

		twitter.postTweet(1, "Lint");
		Assert.assertEquals(1, twitter.getNewsFeed(1).size());
		Assert.assertEquals(1, twitter.getTimeline(1).size());

		twitter.follow(2, 1);
		twitter.postTweet(1, "Code");
		twitter.postTweet(2, "Hello");
		twitter.postTweet(2, "World");
		Assert.assertEquals(4, twitter.getNewsFeed(2).size());
		Assert.assertEquals(4, twitter.getNewsFeed(2).size());
		twitter.unfollow(2, 1);
		Assert.assertEquals(2, twitter.getNewsFeed(2).size());
	}
}