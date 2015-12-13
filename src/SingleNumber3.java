import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

/*
 * 给出2*n + 2个的数字，除其中两个数字之外其他每个数字均出现两次，找到这两个数字。
 */
public class SingleNumber3 {
	public List<Integer> singleNumberIII(int[] A) {
		List<Integer> list = new ArrayList<Integer>();
		if (A == null || A.length == 0)
			return list;
		int divide = 0;
		for (int i : A)
			divide ^= i;
		int i = 1;
		while ((divide & i) == 0)
			i<<=1;
		int first=0;
		int second=0;
		for(int number:A)
			if((number&i)!=0)
				first^=number;
			else
				second^=number;
		list.add(first);
		list.add(second);
		return list;
	}

	@Test
	public void test() {
		List<Integer> list = singleNumberIII(new int[] { 1, 2, 2, 3, 4, 4, 5, 3 });
		Assert.assertTrue(list.contains(1));
		Assert.assertTrue(list.contains(5));
	}
}
