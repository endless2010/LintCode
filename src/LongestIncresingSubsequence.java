import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * ����һ���������У��ҵ�����������У�LIS��������LIS�ĳ��ȡ�
 * ����[5,4,1,2,3]�����LIS��[1,2,3]������ 3
 * ����[4,2,4,5,3,7]�����LIS��[4,4,5,7]������ 4
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
			// �ҳ���ǰ��֮ǰ������������г���
			for (int j = 0; j < i; j++) {
				if (lis[j] > localMax && nums[j] <= nums[i]) {
					localMax = lis[j];
				}
			}
			lis[i] = localMax + 1;// ��ǰ�����Ǹþֲ�����������ȼ�1
			max = Math.max(max, lis[i]);// �õ�ǰ��ĳ��ȸ���ȫ����󳤶�
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
