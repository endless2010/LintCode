import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给一个数组 nums 写一个函数将 0 移动到数组的最后面，非零元素保持原数组的顺序 
 * 1.必须在原数组上操作 
 * 2.最小化操作数 
 * 给出 nums = [0, 1, 0, 3, 12], 调用函数之后, nums = [1, 3, 12, 0, 0].
 *
 */
public class MoveZeros {
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int index0 = 0;
		int indexNot0 = 0;
		int end = nums.length;
		while (index0 < end && indexNot0 < end) {
			while (index0 < end && nums[index0] != 0)
				index0++;
			indexNot0 = index0 + 1;
			while (indexNot0 < end && nums[indexNot0] == 0)
				indexNot0++;
			if (index0 < end && indexNot0 < end) {
				nums[index0] = nums[indexNot0];
				nums[indexNot0] = 0;
				index0++;
			}
		}
	}

	@Test
	public void test() {
		int[] nums;
		nums = new int[] { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
		Assert.assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, nums);

		nums = new int[] { 1, 0, 0, 3, 12 };
		moveZeroes(nums);
		Assert.assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, nums);

	}
}
