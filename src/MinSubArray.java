import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

/*
 * 给定一个整数数组，找到一个具有最小和的子数组。返回其最小和。
 * 子数组最少包含一个数字
 */
public class MinSubArray {
    public int minSubArray(ArrayList<Integer> nums) {
        if(nums==null || nums.size()==0)
    		return 0;
    	int totalSum=Integer.MAX_VALUE;
    	int currSum=0;
    	for(int i=0;i<nums.size();++i){
    		if(currSum>=0)
    			currSum=nums.get(i);
    		else
    			currSum+=nums.get(i);
    		if(currSum<totalSum)
    			totalSum=currSum;
    	}
        return totalSum;
    }
    public ArrayList<Integer> toArrayList(int[] nums){
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	for(int num:nums)
    		list.add(num);
    	return list;
    }
    @Test
    public void test(){
    	Assert.assertEquals(1,  minSubArray(toArrayList(new int[]{1,1,1})));
    	Assert.assertEquals(-5, minSubArray(toArrayList(new int[]{-2,1,-3,4,-1,2,1,-5,4})));
    	Assert.assertEquals(-6, minSubArray(toArrayList(new int[]{-1,-2,-3})));
    	Assert.assertEquals(-3, minSubArray(toArrayList(new int[]{1, -1, -2, 1})));
    }
}
