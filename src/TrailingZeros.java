import org.junit.Assert;
import org.junit.Test;

public class TrailingZeros {

	public long trailingZeros(long n) {
		long result = 0;
		while (n > 0) {
			result += n / 5;
			n /= 5;
		}
		return result;
	}

	@Test
	public void test() {
		Assert.assertEquals(0, trailingZeros(2));
		Assert.assertEquals(1, trailingZeros(5));
		Assert.assertEquals(2, trailingZeros(10));
		Assert.assertEquals(4, trailingZeros(24));
		Assert.assertEquals(6, trailingZeros(25));
		Assert.assertEquals(6, trailingZeros(26));
		Assert.assertEquals(31, trailingZeros(125));
		Assert.assertEquals(1388887499996L, trailingZeros(5555550000000L));
	}
}
