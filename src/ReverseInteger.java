import org.junit.Assert;
import org.junit.Test;


public class ReverseInteger {
	public int reverseInteger(int n) {
		boolean positive = true;
		long input = n;
		if (input < 0) {
			input = -input;
			positive = false;
		}
		long output = 0;
		while (input > 0) {
			output = output * 10 + input % 10;
			input /= 10;
		}
		if (output > Integer.MAX_VALUE)
			return 0;
		else
			return positive ? (int) output : -(int) output;
	}
	
	@Test
	public void test() {
		Assert.assertEquals(1, reverseInteger(1));
		Assert.assertEquals(321, reverseInteger(123));
		Assert.assertEquals(-123, reverseInteger(-321));
		Assert.assertEquals(1, reverseInteger(100000));
		Assert.assertEquals(0, reverseInteger(1212345678));
	}
}
