import org.junit.Assert;
import org.junit.Test;

/*
 * ��������k��0��n�еĳ��ֵĴ�����k������0~9��һ��ֵ
 * ����n=12��k=1���� [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]�����Ƿ���1������5�� (1, 10, 11, 12)
 */
public class DigitCount {
	//TODO: brute force
	public int digitCounts(int k, int n) {
		int sum = 0;
		char chark = (char) ('0' + k);
		for (int i = 0; i <= n; i++) {
			String str = String.valueOf(i);
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == chark)
					sum++;
			}
		}
		return sum;
	}

	@Test
	public void test() {
		Assert.assertEquals(2, digitCounts(0, 12));
		Assert.assertEquals(5, digitCounts(1, 12));
		Assert.assertEquals(2, digitCounts(2, 12));
		Assert.assertEquals(1, digitCounts(3, 12));
	}
}
