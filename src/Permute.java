import java.util.ArrayList;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given a list of numbers, return all possible permutations.
 * For nums = [1,2,3], the permutations are:
 * 
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permute {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
    	Collections.sort(nums);
    	ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    	boolean[] used=new boolean[nums.size()];
    	helper(nums,new ArrayList<Integer>(),result,used);
    	return result;
    }
    
    private void helper(ArrayList<Integer> nums, ArrayList<Integer> subset,
			ArrayList<ArrayList<Integer>> result, boolean[] used) {
		if(subset.size()==nums.size()){
			ArrayList<Integer> clone=new ArrayList<Integer>(subset);
			result.add(clone);
			return;
		}
		for(int i=0;i<nums.size();++i){
			if(used[i])
				continue;
			subset.add(nums.get(i));
			used[i]=true;
			helper(nums,subset,result,used);
			subset.remove(subset.size()-1);
			used[i]=false;
		}
		
	}

	@Test
    public void test(){
    	ArrayList<ArrayList<Integer>> permutations=permute(LintCodeUtils.toArrayList(new int[]{1,2,3}));
    	Assert.assertEquals(6,permutations.size());
    	Assert.assertEquals(true,permutations.contains(LintCodeUtils.toArrayList(new int[]{1,2,3})));
    	Assert.assertEquals(true,permutations.contains(LintCodeUtils.toArrayList(new int[]{1,3,2})));
    	Assert.assertEquals(true,permutations.contains(LintCodeUtils.toArrayList(new int[]{2,1,3})));
    	Assert.assertEquals(true,permutations.contains(LintCodeUtils.toArrayList(new int[]{2,3,1})));
    	Assert.assertEquals(true,permutations.contains(LintCodeUtils.toArrayList(new int[]{3,1,2})));
    	Assert.assertEquals(true,permutations.contains(LintCodeUtils.toArrayList(new int[]{3,2,1})));
    	
    }
}
