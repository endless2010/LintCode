import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Numbers keep coming, return the median of numbers at every time a new number
 * added.
 * 
 * Median is the number that in the middle of a sorted array. If there are n
 * numbers in a sorted array A, the median is A[(n - 1) / 2]. For example, if
 * A=[1,2,3], median is 2. If A=[1,19], median is 1.
 * 
 * For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3]. For numbers
 * coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3]. For numbers
 * coming list: [2, 20, 100], return [2, 2, 20].
 * 
 */
public class DataStreamMedium {
	public int[] medianII(int[] nums) {
		if (nums == null)
			return null;
		int[] res = new int[nums.length];

		PriorityQueue<Integer> bigger = new PriorityQueue<Integer>();
		PriorityQueue<Integer> smaller = new PriorityQueue<Integer>(
				nums.length, new Comparator<Integer>() {
					@Override
					public int compare(Integer x, Integer y) {
						return y - x;
					}
				});
		res[0] = nums[0];
		smaller.add(nums[0]);

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] <= smaller.peek()) {
				smaller.add(nums[i]);
			} else {
				bigger.add(nums[i]);
			}
			if (smaller.size() > bigger.size() + 1) {
				bigger.add(smaller.poll());
			} else if (smaller.size() < bigger.size()) {
				smaller.add(bigger.poll());
			}
			res[i] = smaller.peek();
		}
		return res;
	}
	
	@Test
	public void test() {
		Assert.assertArrayEquals(new int[] { 1, 1, 2, 2, 3 },medianII(new int[] { 1, 2, 3, 4, 5 }));
		Assert.assertArrayEquals(new int[] { 4, 4, 4, 3, 3, 3, 3 },medianII(new int[] { 4, 5, 1, 3, 2, 6, 0 }));
		Assert.assertArrayEquals(new int[] { 2, 2, 20 }, medianII(new int[] {2, 20, 100 }));
	}
}
