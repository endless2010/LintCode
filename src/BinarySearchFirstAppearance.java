import org.junit.Assert;
import org.junit.Test;

/*
 * 给定一个排序的整数数组（升序）和一个要查找的整数target
 * 用O(logn)的时间查找到target第一次出现的下标（从0开始），如果target不存在于数组中，返回-1。
 * 在数组 [1, 2, 3, 3, 4, 5, 10] 中二分查找3，返回2
 * Challenge:如果数组中的整数个数超过了2^32，你的算法是否会出错？
 */
public class BinarySearchFirstAppearance {
	public int binarySearch(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int front = 0;
		int end = nums.length - 1;
		int mid = -1;
		while (front <= end) {
			mid = (front + end) / 2;
			if (nums[mid] == target)
				break;
			else if (nums[mid] < target) {
				front = mid + 1;
			} else
				end = mid - 1;
		}
		if(front>end)
			return -1;
		while(mid>=0 &&nums[mid]==target)
			mid--;
		return mid+1;
	}

	@Test
	public void test() {
		Assert.assertEquals(0, binarySearch(new int[] { 1, 2, 2, 2, 4 }, 1));
		Assert.assertEquals(1, binarySearch(new int[] { 1, 2, 2, 2, 4 }, 2));
		Assert.assertEquals(4, binarySearch(new int[] { 1, 2, 2, 2, 4 }, 4));
		Assert.assertEquals(-1, binarySearch(new int[] { 1, 2, 2, 2,4}, 6));
	}
}