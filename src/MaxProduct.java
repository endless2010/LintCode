import org.junit.Assert;
import org.junit.Test;

//TODO:0?
public class MaxProduct {
		pub lic int maxProduct(int[] nums){
			if(nums==null||nums.length==0)
				return Integer.MIN_VALUE;
			if(nums.length==1)
				return nums[0];
			int numsNegtive=0;
			for(int i=0;i<nums.length;++i)
				if(nums[i]<0)
					numsNegtive++;
			if(numsNegtive%2==0)
				return mul(nums,0,nums.length);
			int from=0;
			int to=nums.length-1;
			while(nums[from]>0)
				++from;
			int left=mul(nums,++from,nums.length);
			while(nums[to]>0)
				--to;
			int right=mul(nums,0,to);
			return left>right?left:right;
		}

		private int mul(int[] nums, int from, int to) {
			int result=1;
			for(int i=from;i<to;++i)
				result*=nums[i];
			return result;
		}
		
		@Test
		public void test(){
			Assert.assertEquals(-1,maxProduct(new int[]{-1}));
			Assert.assertEquals(6,maxProduct(new int[]{2,3}));
			Assert.assertEquals(3,maxProduct(new int[]{-2,3}));
			Assert.assertEquals(6,maxProduct(new int[]{1,2,3}));
			Assert.assertEquals(24,maxProduct(new int[]{1,-2,-3,4}));
			Assert.assertEquals(6,maxProduct(new int[]{2,3,-2,4}));
			Assert.assertEquals(6,maxProduct(new int[]{1,-2,-3}));
			Assert.assertEquals(6,maxProduct(new int[]{-1,-2,-3}));
		}
}
