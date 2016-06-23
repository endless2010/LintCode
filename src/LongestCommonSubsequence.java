import org.junit.Assert;
import org.junit.Test;

/**
 * Given two strings, find the longest common subsequence (LCS). Your code
 * should return the length of LCS.
 * 
 * Clarification What's the definition of Longest Common Subsequence?
 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 * http://baike.baidu.com/view/2020307.htm
 * 
 * For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1. For "ABCD" and
 * "EACB", the LCS is "AC", return 2.
 * 
 */
public class LongestCommonSubsequence {
	@Test
	public void test() {
		Assert.assertEquals(1, longestCommonSubsequence("ABCD", "EDCA"));
		Assert.assertEquals(2, longestCommonSubsequence("ABCD", "EACB"));
	}

	public int longestCommonSubsequence(String A, String B) {
		if (A == null || A.length() == 0 || B == null || B.length() == 0)
			return 0;
		int max = 0;
		int[][] dp = new int[A.length()][B.length()];
		// f[i,j] = max{f[i-1][j -1] + same(i,j),f[i-1,j],f[i,j-1]}
		for (int i = 0; i < A.length(); ++i) {
			for (int j = 0; j < B.length(); ++j) {
				int value = A.charAt(i) == B.charAt(j) ? 1:0;
				if (i >= 1 && j >= 1)
					dp[i][j] = max(dp[i - 1][j - 1] + value, dp[i - 1][j],dp[i][j - 1]);
				else if (i >= 1)
					dp[i][j] = Math.max(value, dp[i - 1][j]);
				else if (j >= 1)
					dp[i][j] = Math.max(value, dp[i][j - 1]);
				else
					dp[i][j] = value;
				if (dp[i][j] > max)
					max = dp[i][j];
			}
		}
		return max;
	}

	private int max(int i, int j, int k) {
		int tmp = i > j ? i : j;
		return tmp > k ? tmp : k;
	}
}
