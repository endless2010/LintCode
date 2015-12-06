import org.junit.Assert;
import org.junit.Test;

/*
 * 给出一个包含 0 .. N 中 N 个数的序列，找出0 .. N 中没有出现在序列中的那个数
 * N = 4 且序列为 [0, 1, 3] 时，缺失的数为2。
 * 可以改变序列中数的位置。在数组上原地完成，使用O(1)的额外空间和O(N)的时间。
 */
public class FindMissing {
	public int findMissing(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; ++i)
			sum += nums[i];
		return (nums.length * (nums.length + 1)) / 2 - sum;
	}

	@Test
	public void test() {
		Assert.assertEquals(2, findMissing(new int[] { 0, 1, 3 }));
		Assert.assertEquals(2, findMissing(new int[] { 1, 0, 3 }));
		Assert.assertEquals(2, findMissing(new int[] { 3, 1, 0 }));
		Assert.assertEquals(1, findMissing(new int[] { 3, 4, 5, 0, 2 }));
	}
}
