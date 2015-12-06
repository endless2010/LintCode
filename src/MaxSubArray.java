import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;


public class MaxSubArray {
	 public int maxSubArray(ArrayList<Integer> nums) {
	    	if(nums==null || nums.size()==0)
	    		return 0;
	    	int totalSum=Integer.MIN_VALUE;
	    	int currSum=0;
	    	for(int i=0;i<nums.size();++i){
	    		if(currSum<=0)
	    			currSum=nums.get(i);
	    		else
	    			currSum+=nums.get(i);
	    		if(currSum>totalSum)
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
	    	Assert.assertEquals(3, maxSubArray(toArrayList(new int[]{1,1,1})));
	    	Assert.assertEquals(6, maxSubArray(toArrayList(new int[]{-2,1,-3,4,-1,2,1,-5,4})));
	    	Assert.assertEquals(-1, maxSubArray(toArrayList(new int[]{-1,-2,-3})));
	    }
}
