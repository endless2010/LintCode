import org.junit.Assert;
import org.junit.Test;


//http://blog.csdn.net/lanxu_yy/article/details/11907615
public class SortColors {

	public void sortColors(int[] nums) {
		int r = -1;
		int b = nums.length;
		for (int i = 0; i < b; i++) {
			if (nums[i] == 0) {
				swap(nums, ++r, i);
			} else if (nums[i] == 2) {
				swap(nums, --b, i);
				i--;
			}
		}
	}

	public void swap(int[] a, int b, int c) {
		int temp = a[b];
		a[b] = a[c];
		a[c] = temp;
	}

	@Test
	public void test() {
		int[] array = { 2, 1, 0, 2, 1, 0, 2, 1, 2, 0, 2, 1, 1, 1, 2 };
		sortColors(array);
		Assert.assertArrayEquals(array, new int[] { 0, 0, 0, 1, 1, 1, 1, 1, 1,
				2, 2, 2, 2, 2, 2 });
		int[] array1 = { 0, 0 };
		sortColors(array1);
		Assert.assertArrayEquals(array1, new int[] { 0, 0 });
	}
