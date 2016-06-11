import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

/**
 * ����һ���ַ��� A, ��ʾһ�� n λ������, ɾ������ k λ����, ʹ��ʣ���������Ȼ����ԭ����˳�����в���һ���µ��������� 
 * �ҵ�ɾ�� k������֮�����С�������� N <= 240, k <= N 
 * ����һ���ַ�������������� A ��һ������ k, ���� A = 178542, k = 4
 * ����һ���ַ��� "12"
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
