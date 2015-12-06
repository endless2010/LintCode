import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class LongestUnrepeetString {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLength = 0;
		int startPosition = 0;
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (map.containsKey(c) && map.get(c) >= startPosition)
				startPosition = map.get(c) + 1;
			map.put(c, i);
			maxLength = Math.max(i - startPosition + 1, maxLength);
		}
		return maxLength;
	}
	@Test
	public void test(){
		Assert.assertEquals(5,lengthOfLongestSubstring("abcde"));
		Assert.assertEquals(1,lengthOfLongestSubstring("aaaaa"));
		Assert.assertEquals(3,lengthOfLongestSubstring("ababc"));
		Assert.assertEquals(4,lengthOfLongestSubstring("abcda"));
	}
}