import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: [7] ,[2, 2, 3] 
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        if(candidates==null || candidates.length==0)
        	return result;
        Arrays.sort(candidates);
        int i=0;
        while(i<candidates.length){
        	if(candidates[i]>target)
        		break;
        	if(candidates[i]==target){
        		List<Integer> list=new ArrayList<Integer>();
        		list.add(candidates[i]);
        		result.add(list);
        	}else{
        		
        	}
        }
        return result;
    }
}
