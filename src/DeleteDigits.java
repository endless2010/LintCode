import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给出一个字符串 A, 表示一个 n 位正整数, 删除其中 k 位数字, 使得剩余的数字仍然按照原来的顺序排列产生一个新的正整数。 
 * 找到删除 k个数字之后的最小正整数。 N <= 240, k <= N 
 * 给出一个字符串代表的正整数 A 和一个整数 k, 其中 A = 178542, k = 4
 * 返回一个字符串 "12"
 * http://www.cnblogs.com/kittyamin/p/5055950.html
 */
public class DeleteDigits {
	public String DeleteDigits(String A, int k) {
		if (A == null || A.length() == 0 || k < 0 || k > A.length())
			return "";

		StringBuilder sb = new StringBuilder(A);
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < sb.length(); j++) {
				if (j == sb.length() - 1 || sb.charAt(j) > sb.charAt(j + 1)) {
					sb.deleteCharAt(j);
					break;
				}
			}
		}
		int i = 0;
		for (; i < sb.length(); i++) {
			if (sb.charAt(i) != '0')
				break;
		}
		return sb.substring(i, sb.length());
	}

	@Test
	public void test() {
		Assert.assertEquals("17542", DeleteDigits("178542", 1));
		Assert.assertEquals("1542", DeleteDigits("178542", 2));
		Assert.assertEquals("142", DeleteDigits("178542", 3));
		Assert.assertEquals("12", DeleteDigits("178542", 4));
		Assert.assertEquals("1", DeleteDigits("178542", 5));
	}
}
