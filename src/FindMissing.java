import org.junit.Assert;
import org.junit.Test;

/*
 * ����һ������ 0 .. N �� N ���������У��ҳ�0 .. N ��û�г����������е��Ǹ���
 * N = 4 ������Ϊ [0, 1, 3] ʱ��ȱʧ����Ϊ2��
 * ���Ըı�����������λ�á���������ԭ����ɣ�ʹ��O(1)�Ķ���ռ��O(N)��ʱ�䡣
 */
public class FindMissing {
	public int findMissing(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; ++i)
			sum += nums[i];
		return (nums.length * (nums.length + 1)) / 2 - sum;
	}

	@Test
	public void test() {
		Assert.assertEquals(2, findMissing(new int[] { 0, 1, 3 }));
		Assert.assertEquals(2, findMissing(new int[] { 1, 0, 3 }));
		Assert.assertEquals(2, findMissing(new int[] { 3, 1, 0 }));
		Assert.assertEquals(1, findMissing(new int[] { 3, 4, 5, 0, 2 }));
	}
}
