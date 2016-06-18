import org.junit.Assert;
import org.junit.Test;

/**
 * After robbing those houses on that street, the thief has found himself a new place for his thievery so that 
 * he will not get too much attention. This time, all houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. 
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */

public class HouseRobber2 {
    public int houseRobber2(int[] nums) {  
        if(nums==null || nums.length==0) return 0;  
        if(nums.length==1) return nums[0];  
        if(nums.length==2) return Math.max(nums[0], nums[1]);  
        return Math.max(robsub(nums, 0, nums.length-2), robsub(nums, 1, nums.length-1));  
    }  
      
    private int robsub(int[] nums, int start, int end) {  
        int n = end - start + 1;  
        int[] d =new int[n];  
        d[0] = nums[start];  
        d[1] = Math.max(nums[start], nums[start+1]);  
          
        for(int i=2; i<n; i++) {  
            d[i] = Math.max(d[i-2]+nums[start+i], d[i-1]);  
        }  
        return d[n-1];  
    }
    
	@Test
	public void test(){
		Assert.assertEquals(8,houseRobber2(new int[]{3,8,4}));
		Assert.assertEquals(6,houseRobber2(new int[]{3,6,4}));
		Assert.assertEquals(6,houseRobber2(new int[]{1,2,3,4}));
		Assert.assertEquals(7,houseRobber2(new int[]{2,1,3,6}));
		
	}
}
