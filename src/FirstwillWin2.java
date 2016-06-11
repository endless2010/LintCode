import org.junit.Assert;
import org.junit.Test;

/*
 * There are n coins with different value in a line. 
 * Two players take turns to take one or two coins from left side until there are no more coins left. 
 * The player who take the coins with the most value wins.
 * Could you please decide the first player will win or lose?
 * Given values array A = [1,2,2], return true.
 * Given A = [1,2,4], return false.
 */
public class FirstwillWin2 {
	public boolean firstWillWin(int[] values) {
		if (values.length < 3)
			return true;
		int length = values.length;
		int[] dp1 = new int[length];
		dp1[length - 1] = values[length - 1];
		dp1[length - 2] = values[length - 1] + values[length - 2];
		int[] dp2 = new int[length];
		for (int i = length - 3; i >= 0; --i) {
			int take1 = values[i] + dp2[i + 1];
			int take2 = values[i] + values[i + 1] + dp2[i + 2];
			if (take1 > take2) {
				dp1[i] = take1;
				dp2[i] = dp1[i + 1];
			} else {
				dp1[i] = take2;
				dp2[i] = dp1[i + 2];
			}
		}
		return dp1[0] > dp2[0];
	}

	@Test
	public void test() {
		Assert.assertEquals(true, firstWillWin(new int[] { 1 }));
		Assert.assertEquals(true, firstWillWin(new int[] { 1, 2 }));
		Assert.assertEquals(true, firstWillWin(new int[] { 1, 2, 2 }));
		Assert.assertEquals(false, firstWillWin(new int[] { 1, 2, 4 }));
		Assert.assertEquals(true, firstWillWin(new int[] { 1, 5, 2, 2 }));
		Assert.assertEquals(true, firstWillWin(new int[] { 1, 2, 3, 5 }));
		Assert.assertEquals(false, firstWillWin(new int[] { 1, 2, 5, 3 }));
	}
}
