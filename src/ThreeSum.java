import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组。
 * 在三元组(a, b, c)，要求a <= b <= c。
 * 结果不能包含重复的三元组。
 * 如S = {-1 0 1 2 -1 -4}, 你需要返回的三元组集合的是：
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
