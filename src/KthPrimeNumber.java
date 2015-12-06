import org.junit.Assert;
import org.junit.Test;

/*
 * 设计一个算法，找出只含素因子3，5，7 的第 k 大的数
 * 符合条件的数如：3，5，7，9，15......
 */
public class KthPrimeNumber {
	public long kthPrimeNumber(int k) {
		if(k <= 0)  
	        return 0;  
	  
		long[] nums=new long[k+2];
	    nums[0]=3;
	    nums[1]=5;
	    nums[2]=7;
	    int current= 3; 
	    int i3 = 0;  
	    int i5 = 1;  
	    int i7 = 2;    
	    while(current < k)  {  
	        long min = Math.min(Math.min(3*nums[i3],5*nums[i5]),7*nums[i7]);
	        nums[current] = min;  
	          
	        while(3*nums[i3] <= nums[current])  
	            ++i3;  
	        while(5*nums[i5] <= nums[current])  
	            ++i5;  
	        while(7*nums[i7]<= nums[current])  
	            ++i7;  	  
	        ++current;  
	    }  
	    return nums[k-1];  
	}


	@Test
	public void test(){
		Assert.assertEquals(3,kthPrimeNumber(1));
		Assert.assertEquals(5,kthPrimeNumber(2));
		Assert.assertEquals(7,kthPrimeNumber(3));
		Assert.assertEquals(9,kthPrimeNumber(4));
		Assert.assertEquals(15,kthPrimeNumber(5));
		Assert.assertEquals(21,kthPrimeNumber(6));
		Assert.assertEquals(25,kthPrimeNumber(7));
		Assert.assertEquals(27,kthPrimeNumber(8));
		Assert.assertEquals(35,kthPrimeNumber(9));
		Assert.assertEquals(45,kthPrimeNumber(10));
		Assert.assertEquals(49,kthPrimeNumber(11));
		Assert.assertEquals(1102959375,kthPrimeNumber(599));
		Assert.assertEquals(221475379545L,kthPrimeNumber(1111));
	}
}
