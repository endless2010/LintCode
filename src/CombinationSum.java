import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T. The same repeated
 * number may be chosen from C unlimited number of times.
 * 
 * For example, given candidate set 2,3,6,7 and target 7, A solution set is: [7]
 * , [2, 2, 3] All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order.
 * (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak). The solution set must not contain duplicate
 * combinations.
 * 
 */
public class CombinationSum {
	@Test
	public void test() {
		List<List<Integer>> list = combinationSum(new int[] { 2, 3, 6, 7 }, 7);
		System.out.println(list);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		Arrays.sort(candidates);
		combinationSum(res, candidates, target, 0, temp);
		return res;
	}

	public void combinationSum(List<List<Integer>> res, int[] candidates,
			int target, int level, List<Integer> temp) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(temp));
		} else if (target >0) {
			for (int i = level; i < candidates.length; i++) {
				temp.add(candidates[i]);
				combinationSum(res, candidates, target-candidates[i], i,temp);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
