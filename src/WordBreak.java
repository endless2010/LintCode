import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
 * ����һ���ַ���s��һ���ʵ䣬�ж��ַ���s�Ƿ���Ա��ո��зֳ�һ�������������ֵ��еĵ��ʡ�
 * s = "lintcode" dict = ["lint","code"]
 * ���� true ��Ϊ"lintcode"���Ա��ո��зֳ�"lint code"
 */
public class WordBreak {

	public boolean wordBreak(String s, Set<String> dict) {
		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] && dict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}
		return f[s.length()];
	}

	@Test
	public void test() {
		Set<String> dict = new HashSet<String>();
		dict.add("lint");
		dict.add("code");
		dict.add("lintxx");
		dict.add("is");
		dict.add("fun");
		Assert.assertEquals(true, wordBreak("lintcode", dict));
		Assert.assertEquals(true, wordBreak("lint", dict));
		Assert.assertEquals(true, wordBreak("code", dict));
		Assert.assertEquals(false, wordBreak("lintco", dict));
		Assert.assertEquals(true, wordBreak("lintcodeis", dict));
		Assert.assertEquals(true, wordBreak("lintxxis", dict));
		Assert.assertEquals(false, wordBreak("lintyyis", dict));
		Assert.assertEquals(true, wordBreak("lintcodeisfun", dict));
		Assert.assertEquals(false, wordBreak("null", new HashSet<String>()));
		Assert.assertEquals(true, wordBreak("", new HashSet<String>()));
	}
}
