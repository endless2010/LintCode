import org.junit.Assert;
import org.junit.Test;

//TODO:0?
public class MaxProduct {
	public int maxProduct(int[] nums){
			if(nums==null||nums.length==0)
				return Integer.MIN_VALUE;
			if(nums.length==1)
				return nums[0];
			 int[] Min=new int[nums.length];  
			 int[] Max=new int[nums.length];    

			 Min[0]=nums[0];  
			 Max[0]=nums[0];  
			 int maxValue=Max[0];  
			 
			 for(int i=1;i<nums.length;i++){  
			  Max[i]=Math.max((Max[i-1]*nums[i]),Math.max(Min[i-1]*nums[i],nums[i]));  
			  Min[i]=Math.min((Max[i-1]*nums[i]),Math.min(Min[i-1]*nums[i],nums[i]));  
			  if(maxValue<Max[i])  
				  maxValue=Max[i];  
			 }
			 return maxValue;
		}

	@Test
	public void test() {
		Assert.assertEquals(-1, maxProduct(new int[] { -1 }));
		Assert.assertEquals(6, maxProduct(new int[] { 2, 3 }));
		Assert.assertEquals(3, maxProduct(new int[] { -2, 3 }));
		Assert.assertEquals(6, maxProduct(new int[] { 1, 2, 3 }));
		Assert.assertEquals(24, maxProduct(new int[] { 1, -2, -3, 4 }));
		Assert.assertEquals(6, maxProduct(new int[] { 2, 3, -2, 4 }));
		Assert.assertEquals(6, maxProduct(new int[] { 1, -2, -3 }));
		Assert.assertEquals(6, maxProduct(new int[] { -1, -2, -3 }));
		Assert.assertEquals(1, maxProduct(new int[] { -3, 0, 1, -2 }));
	}
}
