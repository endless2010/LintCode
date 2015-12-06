import org.junit.Assert;
import org.junit.Test;

/*
 * 计算在一个 32 位的整数的二进制表式中有多少个 1.
 */
public class CountOnes {
	public int countOnes(int num) {
		int count = 0;
		while (num != 0) {
			if ((num & 1) == 1)
				count++;
			num >>>= 1;
		}
		return count;
	}

	@Test
	public void test() {
		Assert.assertEquals(1, countOnes(32));
		Assert.assertEquals(2, countOnes(5));
		Assert.assertEquals(10, countOnes(1023));
		Assert.assertEquals(31, countOnes(Integer.MAX_VALUE));
	}
}
