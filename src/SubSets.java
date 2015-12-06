import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

/*
 * 给定一个含不同整数的集合，返回其所有的子集
 */
public class SubSets {
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        if(nums==null || nums.length==0)
        	return result;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;++i){
        	ArrayList<ArrayList<Integer>> tmp=new ArrayList<ArrayList<Integer>>();
        	for(ArrayList<Integer> list:result){
        		tmp.add(list);
        		ArrayList<Integer> clone=new ArrayList<Integer>(list);
        		clone.add(nums[i]);
        		tmp.add(clone);
        	}
        	result=tmp;
        }
        return result;
    }
    @Test
    public void test(){
    	ArrayList<ArrayList<Integer>> list1=subsets(new int[]{1,3,2});
    	System.out.println(list1);
    	ArrayList<ArrayList<Integer>> list2=subsets(new int[]{4,1,0});
    	System.out.println(list2);
    }
}
