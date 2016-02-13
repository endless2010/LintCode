import java.util.ArrayList;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

/*
 * 给定一个可能具有重复数字的列表，返回其所有可能的子集
 * 如果 S = [1,2,2]，一个可能的答案为：
 * 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * 注意
 * 子集中的每个元素都是非降序的
 * 两个子集间的顺序是无关紧要的
 * 解集中不能包含重复子集
 */
public class SubsetsWithDup {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
    	Collections.sort(S);
    	ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    	helper(S,0,new ArrayList<Integer>(),result);
    	return result;
    }
    
    private void helper(ArrayList<Integer> S,int start, ArrayList<Integer> subset,
			ArrayList<ArrayList<Integer>> result) {
    	if(start>S.size())
    		return;
    	ArrayList<Integer> clone=new ArrayList<Integer>(subset);
		result.add(clone);
		for(int i=start;i<S.size();++i){
			if(i!=start && S.get(i)==S.get(i-1))
				continue;
			subset.add(S.get(i));
			helper(S,i+1,subset,result);
			subset.remove(subset.size()-1);
		}
		
	}
    
	@Test
    public void test(){
    	ArrayList<ArrayList<Integer>> permutations=subsetsWithDup(LintCodeUtils.toArrayList(new int[]{1,2,2}));
    	Assert.assertEquals(6,permutations.size());
    	Assert.assertEquals(true,permutations.contains(LintCodeUtils.toArrayList(new int[]{})));
    	Assert.assertEquals(true,permutations.contains(LintCodeUtils.toArrayList(new int[]{1})));
    	Assert.assertEquals(true,permutations.contains(LintCodeUtils.toArrayList(new int[]{2}))); 
    	Assert.assertEquals(true,permutations.contains(LintCodeUtils.toArrayList(new int[]{1,2})));
    	Assert.assertEquals(true,permutations.contains(LintCodeUtils.toArrayList(new int[]{2,2})));
    	Assert.assertEquals(true,permutations.contains(LintCodeUtils.toArrayList(new int[]{1,2,2})));
    }
}
