import org.junit.Assert;
import org.junit.Test;

public class SearchInsertPosition {
	
	public int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0)
			return 0;
		int front = 0;
		int end = A.length - 1;
		int mid = -1;
		while (front <= end) {
			mid = (front + end) / 2;
			if (A[mid] == target)
				return mid;
			else if (A[mid] < target) {
				front = mid + 1;
			} else
				end = mid-1;
		}
		if(A[mid]<target)
			return mid+1;
		return mid;
	}

	@Test
	public void test() {
		Assert.assertEquals(2, searchInsert(new int[] {1,2,4 }, 4));
		Assert.assertEquals(0, searchInsert(new int[] {1,2,4 }, -1));
		Assert.assertEquals(2, searchInsert(new int[] {1,2,4 }, 3));
		Assert.assertEquals(2, searchInsert(new int[] {1,3,5,6 }, 5));
		Assert.assertEquals(1, searchInsert(new int[] {1,3,5,6 }, 2));
		Assert.assertEquals(4, searchInsert(new int[] {1,3,5,6 }, 7));
		Assert.assertEquals(0, searchInsert(new int[] {1,3,5,6 }, 0));	
	}
}