import org.junit.Assert;
import org.junit.Test;

/*
 * 判断两个可能包含通配符“？”和“*”的字符串是否匹配。匹配规则如下：
'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个串完全匹配才算匹配成功。
 */
public class RegexMatch {
	public boolean isMatch(String s, String p) {
		return false;
	}

	@Test
	public void test() {
		Assert.assertEquals(false, isMatch("aa", "a"));
		Assert.assertEquals(false, isMatch("aa", "aa"));
		Assert.assertEquals(false, isMatch("aaa", "aa"));
		Assert.assertEquals(false, isMatch("aa", "*"));
		Assert.assertEquals(false, isMatch("aa", "a*"));
		Assert.assertEquals(false, isMatch("ab", "?*"));
		Assert.assertEquals(false, isMatch("aab", "c*a*b"));
	}
}
