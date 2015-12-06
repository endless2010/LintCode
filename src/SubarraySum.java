import java.util.ArrayList;

import org.junit.Test;

/*
 * 给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
 * 给出[-3, 1, 2, -3, 4]，返回[0, 2] 或者 [1, 3].
 * 如果sum[i]和sum[j]相等，则a[i + 1] + ... + a[j] = 0;
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
