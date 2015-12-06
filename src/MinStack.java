import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class MinStack {
	LinkedList<Integer> data = new LinkedList<Integer>();
	LinkedList<Integer> min = new LinkedList<Integer>();

	public MinStack() {
	}

	public void push(int number) {
		data.push(number);
		if (min.size() > 0)
			if (number < min.getFirst())
				min.push(number);
			else
				min.push(min.getFirst());
		else
			min.push(number);
	}

	public int pop() {
		min.removeFirst();
		return data.removeFirst();
	}

	public int min() {
		return min.getFirst();
	}

	@Test
	public void test() {
		MinStack s = new MinStack();
		s.push(4);
		s.push(2);
		s.push(3);
		Assert.assertEquals(2, s.min());
		Assert.assertEquals(3, s.pop());
		Assert.assertEquals(2, s.min());
		Assert.assertEquals(2, s.pop());
		Assert.assertEquals(4, s.min());
	}
}
