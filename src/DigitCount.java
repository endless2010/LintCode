import org.junit.Assert;
import org.junit.Test;

/*
 * 计算数字k在0到n中的出现的次数，k可能是0~9的一个值
 * 例如n=12，k=1，在 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]，我们发现1出现了5次 (1, 10, 11, 12)
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
