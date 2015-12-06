import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/*
 * 给一个整数数组，找到两个数使得他们的和等于一个给定的数target。
 * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是1到n，不是以0开头。
 * 
 */
public class TwoSum {
	 public int[] twoSum(int[] numbers, int target) {
	    	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	    	for(int i=0;i<numbers.length;++i)
	    		map.put(numbers[i],i);
	    	int[] result=new int[2];
	    	for(int i=0;i<numbers.length;++i){
	    		int value=target-numbers[i];
	    		if(map.containsKey(value) && i!=map.get(value)){
	    			result[0]=i+1;
	    			result[1]=map.get(value)+1;
	    			break;
	    		}
	    	}
	    	return result;
	    }

	    @Test
	    public void test(){	
	    	Assert.assertArrayEquals(new int[]{1,2},twoSum(new int[]{2,7,11,15},9));
	    	Assert.assertArrayEquals(new int[]{1,3},twoSum(new int[]{2,7,11,15},13));
	    	Assert.assertArrayEquals(new int[]{2,3},twoSum(new int[]{3,2,4},6));
	    	Assert.assertArrayEquals(new int[]{1,4},twoSum(new int[]{0,3,2,0},0));
	    	Assert.assertArrayEquals(new int[]{1,3},twoSum(new int[]{-1,3,2,0},1));
	    }
}
