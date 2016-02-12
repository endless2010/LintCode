import org.junit.Assert;
import org.junit.Test;

/*
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing 
 * each of them is that adjacent houses have security system connected and it will 
 * automatically contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * Given [3, 8, 4], return 8.
 */
public class HouseRober {
	public long houseRobber(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		if (A.length == 1)
			return A[0];
		if (A.length == 2)
			return A[0] > A[1] ? A[0] : A[1];
		long[] dp = new long[A.length];
		dp[0] = A[0];
		dp[1] = A[0] > A[1] ? A[0] : A[1];
		for (int i = 2; i < A.length; ++i) {
			dp[i] = Math.max(dp[i - 2] + A[i], dp[i - 1]);
		}
		return dp[A.length - 1];
	}

	@Test
	public void test() {
		Assert.assertEquals(8, houseRobber(new int[] { 8 }));
		Assert.assertEquals(8, houseRobber(new int[] { 8, 4 }));
		Assert.assertEquals(8, houseRobber(new int[] { 3, 8, 4 }));
		Assert.assertEquals(7, houseRobber(new int[] { 3, 6, 4 }));
		Assert.assertEquals(6, houseRobber(new int[] { 2, 3, 4, 1 }));
		Assert.assertEquals(9, houseRobber(new int[] { 2, 3, 4, 6 }));
		Assert.assertEquals(9, houseRobber(new int[] { 3, 2, 4, 6 }));
	}
}
