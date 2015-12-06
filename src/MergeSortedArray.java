import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

/*
 * Merge two given sorted integer array A and B into a new sorted integer array.
 */
public class MergeSortedArray {
	public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A,
			ArrayList<Integer> B) {
		if (A == null)
			return B;
		if (B == null)
			return A;
		ArrayList<Integer> result = new ArrayList<Integer>();
		int m = 0;
		int n = 0;
		int index = 0;
		while (index++ < (A.size() + B.size())) {
			if (m >= A.size()){
				result.addAll(B.subList(n, B.size()));
				break;
			}else if (n >= B.size()){
				result.addAll(A.subList(m, A.size()));
				break;
			}else {
				if (A.get(m) <= B.get(n)) {
					result.add(A.get(m++));
				} else {
					result.add(B.get(n++));
				}
			}
		}
		return result;
	}

	@Test
	public void test() {
		int[] nums1 = { 1, 3, 5, 7 };
		int[] nums2 = { 2, 4, 6, 8 };
		ArrayList<Integer> result = mergeSortedArray(
				LintCodeUtils.toArrayList(nums1),
				LintCodeUtils.toArrayList(nums2));
		Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 },
				LintCodeUtils.fromArrayList(result));
		
		int[] nums3 = { 1, 2, 3, 4 };
		int[] nums4 = { 2, 4, 5, 6 };
		ArrayList<Integer> result1 = mergeSortedArray(
				LintCodeUtils.toArrayList(nums3),
				LintCodeUtils.toArrayList(nums4));
		Assert.assertArrayEquals(new int[] { 1, 2, 2, 3, 4, 4, 5, 6 },
				LintCodeUtils.fromArrayList(result1));
	}
}
