import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * 返回两个数组的交 nums1 = [1, 2, 2, 1], nums2 = [2, 2], 返回 [2].
 */
public class IntersectionOf2Array {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
			return new int[]{};
		Set<Integer> set1 = new HashSet<Integer>();
		Set<Integer> set2 = new HashSet<Integer>();
		Set<Integer> joinSet = new HashSet<Integer>();
		for (int i : nums1)
			set1.add(i);
		for (int i : nums2)
			set2.add(i);
		for (int i : set1)
			if (set2.contains(i))
				joinSet.add(i);
		int[] result = new int[joinSet.size()];
		int index = 0;
		for (int i : joinSet)
			result[index++] = i;
		return result;
	}

	@Test
	public void test() {
		Assert.assertArrayEquals(new int[] { 2 },
				intersection(new int[] { 1, 2, 2, 1 }, new int[] { 2, 2 }));

		Assert.assertArrayEquals(new int[] { 2 },
				intersection(new int[] { 1, 2, 2, 1 }, new int[] { 3, 2 }));

		Assert.assertArrayEquals(new int[] {},
				intersection(new int[] { 1, 2, 2, 1 }, new int[] { 3, 4 }));
	}
}
