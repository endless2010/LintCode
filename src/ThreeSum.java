import java.util.ArrayList;
import java.util.Arrays;

/**
 * ����һ����n������������S����S���ҵ���������a, b, c���ҵ�����ʹ��a + b + c = 0����Ԫ�顣
 * ����Ԫ��(a, b, c)��Ҫ��a <= b <= c��
 * ������ܰ����ظ�����Ԫ�顣
 * ��S = {-1 0 1 2 -1 -4}, ����Ҫ���ص���Ԫ�鼯�ϵ��ǣ�
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class ThreeSum {
	
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    if(numbers == null || numbers.length < 3) return result;
	    Arrays.sort(numbers);

	    int len = numbers.length;
	    for(int i = 0; i < len; i++) {
	        if(i > 0 && numbers[i] == numbers[i - 1]) continue;        // Skip same results
	        int target = 0 - numbers[i];
	        int j = i + 1, k = len - 1;
	        while(j < k) {
	            if(numbers[j] + numbers[k] == target) {
	            	ArrayList<Integer> list=new ArrayList<Integer>();
	            	list.add(numbers[i]);list.add(numbers[j]);list.add(numbers[k]);
	                result.add(list);
	                while(j < k && numbers[j] == numbers[j + 1]) j++;  // Skip same results
	                while(j < k && numbers[k] == numbers[k - 1]) k--;  // Skip same results
	                j++; k--;
	            } else if(numbers[j] + numbers[k] < target) {
	                j++;
	            } else {
	                k--;
	            }
	        }
	    }
	    return result;
	}
}
