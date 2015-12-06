import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * ����һ������n. �� 1 �� n ��������Ĺ����ӡÿ������
 * ����������3��������ӡfizz.
 * ����������5��������ӡbuzz.
 * ����������ͬʱ��3��5��������ӡfizz buzz.
 */
public class FizzBuzz {
	public ArrayList<String> fizzBuzz(int n) {
		ArrayList<String> results = new ArrayList<String>();
		for (int i = 1; i <= n; i++) {
			if (i % 15 == 0) {
				results.add("fizz buzz");
			} else if (i % 5 == 0) {
				results.add("buzz");
			} else if (i % 3 == 0) {
				results.add("fizz");
			} else {
				results.add(String.valueOf(i));
			}
		}
		return results;
	}

	@Test
	public void test() {
		ArrayList<String> list = fizzBuzz(15);
		Assert.assertEquals(list,
				Arrays.asList(new String[] { "1", "2", "fizz", "4", "buzz",	"fizz", "7", "8", 
						"fizz", "buzz", "11", "fizz", "13","14", "fizz buzz" }));
	}
}
