import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

/*
 * 给定一个整数数组，请找出一个连续子数组，使得该子数组的和最大。输出答案时，
 * 请分别返回第一个数字下标和最后一个数字下标的值。（如果两个相同的答案，请返回其中任意一个）
 */
public class ContinuousSubArraySum {
	public ArrayList<Integer> continuousSubarraySum(int[] A) {
		ArrayList<Integer> list=new ArrayList<Integer>();
    	if(A==null || A.length==0)
    		return list;
    	int sum=A[0];
    	int current=A[0];
    	int from=0;
    	int to=A.length-1;
    	for(int i=1;i<A.length;++i){
      		if(A[i]>0){
    			from=i;
    		}
    		current=Math.max(A[i], current+A[i]);
      		if(sum<current){
    			to=i;
    		}
    		sum=Math.max(sum, current);
    	}
    	list.add(from);list.add(to);
        return list;
	}
	 
	@Test
	public void test() {
		ArrayList<Integer> list1=LintCodeUtils.toArrayList(new int[]{0,2});
		Assert.assertEquals(list1, continuousSubarraySum(new int[] { 1, 1, 1 }));
		
		ArrayList<Integer> list2=LintCodeUtils.toArrayList(new int[]{3,6});
		Assert.assertEquals(list2, continuousSubarraySum(new int[] { -2, 1, -3, 4,-1, 2, 1, -5, 3 }));
		
		ArrayList<Integer> list3=LintCodeUtils.toArrayList(new int[]{0,0});
		Assert.assertEquals(list3, continuousSubarraySum(new int[] { -1, -2, -3 }));
	}
}
