import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * ����һ���������飬�ҵ���Ԫ�أ����������еĳ��ִ����ϸ��������Ԫ�ظ���������֮һ�� ������ֻ��Ψһ����Ԫ�� ��������[1,2,1,2,1,3,3] ����
 * 1
 */
public class MajorityNumber2 {
	public int majorityNumber(ArrayList<Integer> nums) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = nums.size() / 3;
        for (Integer num : nums) {
            int sum = 1;
            if (map.containsKey(num))
                sum = map.get(num) + 1;
            map.put(num, sum);
            if (sum > count) {
                return num;
            }
        }
        return -1;
	}

	@Test
	public void test() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(1, 2, 1));
		Assert.assertEquals(1, majorityNumber(list));

		list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(1, 1, 1));
		Assert.assertEquals(1, majorityNumber(list));

		list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(1, 2, 1, 1, 2, 2, 1));
		Assert.assertEquals(1, majorityNumber(list));

		list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(99, 2, 99, 2, 99, 3, 3));
		Assert.assertEquals(99, majorityNumber(list));
	}
}
