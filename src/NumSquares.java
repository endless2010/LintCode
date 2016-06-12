import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;


public class NumSquares {
	
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 0; i * i <= n; i++) {
			dp[i * i] = 1;
		}
		for (int a = 0; a <= n; a++) {
			for (int b = 0; a + b * b <= n; b++) {
				dp[a + b * b] = Math.min(dp[a] + 1, dp[a + b * b]);
			}
		}
		return dp[n];
	}

	@Test
	public void test() {
		Assert.assertEquals(1,numSquares(9));
		Assert.assertEquals(2,numSquares(10));
		Assert.assertEquals(3,numSquares(11));
		Assert.assertEquals(3,numSquares(12));
		Assert.assertEquals(2,numSquares(13));
	}
}
