import org.junit.Assert;
import org.junit.Test;

/*
 * ����һ��������������飨���򣩺�һ��Ҫ���ҵ�����target
 * ��O(logn)��ʱ����ҵ�target��һ�γ��ֵ��±꣨��0��ʼ�������target�������������У�����-1��
 * ������ [1, 2, 3, 3, 4, 5, 10] �ж��ֲ���3������2
 * Challenge:��������е���������������2^32������㷨�Ƿ�����
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