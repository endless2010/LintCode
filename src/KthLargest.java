import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;


public class KthLargest {
	public int kthLargestElement(int k, ArrayList<Integer> numbers) {
		if (numbers == null || numbers.size() == 0 || k < 0 || k > numbers.size())
			return -1;
		Queue<Integer> queue = new PriorityQueue<Integer>();
		for (int i = 0; i < numbers.size(); ++i) {
			queue.add(numbers.get(i));
			if (queue.size() > k)
				queue.remove();
		}
		return queue.poll();
	}

	@Test
	public void test() {
		ArrayList<Integer> nums = LintCodeUtils.toArrayList(new int[] { 6, 4, 3, 1, 2, 5 });
		Assert.assertEquals(6, kthLargestElement(1,nums));
		Assert.assertEquals(5, kthLargestElement(2,nums));
		Assert.assertEquals(4, kthLargestElement(3,nums));
		Assert.assertEquals(3, kthLargestElement(4,nums));
		Assert.assertEquals(2, kthLargestElement(5,nums));
		Assert.assertEquals(1, kthLargestElement(6,nums));
	}

}





