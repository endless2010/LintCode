import org.junit.Assert;
import org.junit.Test;

/*
 * ������һ�� 32 λ�������Ķ����Ʊ�ʽ���ж��ٸ� 1.
 */
public class CountOnes {
	public int countOnes(int num) {
		int count = 0;
		while (num != 0) {
			if ((num & 1) == 1)
				count++;
			num >>>= 1;
		}
		return count;
	}

	@Test
	public void test() {
		Assert.assertEquals(1, countOnes(32));
		Assert.assertEquals(2, countOnes(5));
		Assert.assertEquals(10, countOnes(1023));
		Assert.assertEquals(31, countOnes(Integer.MAX_VALUE));
	}
}
