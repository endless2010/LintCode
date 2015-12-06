import java.util.ArrayList;

import org.junit.Test;

/*
 * ����һ���������飬�ҵ���Ϊ��������顣��Ĵ���Ӧ�÷�������Ҫ������������ʼλ�úͽ���λ��
 * ����[-3, 1, 2, -3, 4]������[0, 2] ���� [1, 3].
 * ���sum[i]��sum[j]��ȣ���a[i + 1] + ... + a[j] = 0;
 */
public class SubarraySum {
	public ArrayList<Integer> subarraySum(int[] nums) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (nums == null || nums.length == 0)
			return result;
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
			sum[i] = sum[i - 1] + nums[i];
		for (int i = 0; i < nums.length; i++)
			for (int j = 0; j <= i; j++) {
				if(sum[i]==0){
					result.add(0);
					result.add(i);
					return result;
				}
				else if (sum[i] == sum[j]) {
					result.add(j+1);
					result.add(i);
					return result;
				}
			}
		return result;
	}
	
	@Test
	public void test(){
		ArrayList<Integer> list=subarraySum(new int[]{-3, 1, 2, -3, 4});
		System.out.println(list);
		ArrayList<Integer> list2=subarraySum(new int[]{1,-1});
		System.out.println(list2);
	}
}
