import java.util.ArrayList;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

/*
 * Given a list of numbers with duplicate number in it. Find all unique permutations.
 * For numbers [1,2,2] the unique permutations are:
 * [
 *   [1,2,2],
 *   [2,1,2],
 *   [2,2,1]
 * ]
 * Challenge Using recursion to do it is acceptable. If you can do it without recursion, that would be great!
 */
public class PermuteUnique {
	public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
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
			if(used[i] || (i>0 &&!used[i-1]&& nums.get(i)==nums.get(i-1)))//unique
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
    	ArrayList<ArrayList<Integer>> permutations=permuteUnique(LintCodeUtils.toArrayList(new int[]{1,2,2}));
    	Assert.assertEquals(3,permutations.size());
    	Assert.assertEquals(true,permutations.contains(LintCodeUtils.toArrayList(new int[]{1,2,2})));
    	Assert.assertEquals(true,permutations.contains(LintCodeUtils.toArrayList(new int[]{2,1,2})));
    	Assert.assertEquals(true,permutations.contains(LintCodeUtils.toArrayList(new int[]{2,2,1}))); 	
    }
}
