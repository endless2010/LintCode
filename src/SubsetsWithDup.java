import java.util.ArrayList;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

/*
 * ����һ�����ܾ����ظ����ֵ��б����������п��ܵ��Ӽ�
 * ��� S = [1,2,2]��һ�����ܵĴ�Ϊ��
 * 
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 * ע��
 * �Ӽ��е�ÿ��Ԫ�ض��Ƿǽ����
 * �����Ӽ����˳�����޹ؽ�Ҫ��
 * �⼯�в��ܰ����ظ��Ӽ�
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
