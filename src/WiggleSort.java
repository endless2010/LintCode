import java.util.Arrays;

import org.junit.Test;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <=
 * nums[1] >= nums[2] <= nums[3]....
 * 
 * Please complete the problem in-place.
 * 
 * Given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */

public class WiggleSort {
	public void wiggleSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if ((i % 2 == 1 && nums[i] < nums[i - 1])
					|| (i % 2 == 0 && nums[i] > nums[i - 1])) {
				int tmp = nums[i - 1];
				nums[i - 1] = nums[i];
				nums[i] = tmp;
			}
		}
	}

	@Test
	public void test() {
		int[] nums = { 3, 5, 2, 1, 6, 4 };
		wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
