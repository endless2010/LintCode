import org.junit.Assert;
import org.junit.Test;

/*
 * 假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。
 * 你需要找到其中最小的元素。
 * 数组中可能存在重复的元素。
 */
public class FindMin2 {
	public int findMin(int[] num) {
		int low = 0;
		int high = num.length - 1;
		if (num[low] < num[high])
			return num[low];
		while (low < high) {
			int mid = (low + high) / 2;
			if (num[mid] >= num[high])
				low = mid + 1;
			else
				high = mid;
		}
		return num[low];
	}

	@Test
	public void test() {
		Assert.assertEquals(1, findMin(new int[] { 1, 2, 3, 4, 5, 6 }));
		Assert.assertEquals(1, findMin(new int[] { 2, 3, 4, 5, 6, 1 }));
		Assert.assertEquals(1, findMin(new int[] { 3, 4, 5, 6, 1, 2 }));
		Assert.assertEquals(1, findMin(new int[] { 4, 5, 6, 1, 2, 3 }));
		Assert.assertEquals(1, findMin(new int[] { 5, 6, 1, 2, 3, 4 }));
		Assert.assertEquals(1, findMin(new int[] { 6, 1, 2, 3, 4, 5 }));
		Assert.assertEquals(0, findMin(new int[] { 4, 4, 5, 6, 7, 0, 1, 2 }));
		Assert.assertEquals(-1, findMin(new int[] { 1, 1, -1, 1 }));
	}
}
