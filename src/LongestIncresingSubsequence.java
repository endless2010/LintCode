import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * 给定一个整数序列，找到最长上升子序列（LIS），返回LIS的长度。
 * 给出[5,4,1,2,3]，这个LIS是[1,2,3]，返回 3
 * 给出[4,2,4,5,3,7]，这个LIS是[4,4,5,7]，返回 4
 * http://segmentfault.com/a/1190000003819886
 */
public class LongestIncresingSubsequence {
	public int longestIncreasingSubsequence(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] lis = new int[nums.length];
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int localMax = 0;
			// 找出当前点之前的最大上升序列长度
			for (int j = 0; j < i; j++) {
				if (lis[j] > localMax && nums[j] <= nums[i]) {
					localMax = lis[j];
				}
			}
			lis[i] = localMax + 1;// 当前点则是该局部最大上升长度加1
			max = Math.max(max, lis[i]);// 用当前点的长度更新全局最大长度
		}
		return max;
	}

	@Test
	public void test() {
		Assert.assertEquals(3, longestIncreasingSubsequence(new int[] { 5, 4,
				1, 2, 3 }));
		Assert.assertEquals(3,
				longestIncreasingSubsequence(new int[] { 1, 2, 3 }));
		Assert.assertEquals(1,
				longestIncreasingSubsequence(new int[] { 3, 2, 1 }));
		Assert.assertEquals(4, longestIncreasingSubsequence(new int[] { 4, 2,
				4, 5, 3, 7 }));
	}
}
