import org.junit.Assert;
import org.junit.Test;

/**
 * 写一个程序来检测一个整数是不是丑数。
 * 丑数的定义是，只包含质因子 2, 3, 5 的正整数。比如 6, 8 就是丑数，但是 14 不是丑数以为他包含了质因子 7。
 * 可以认为 1 是一个特殊的丑数。
 * 
 * 给出 num = 8，返回 true。
 * 给出 num = 14，返回 false。
 *
 */
public class IsUgly {
	    /**
	     * @param num an integer
	     * @return true if num is an ugly number or false
	     */
	    public boolean isUgly(int num) {
	    	if(num<1)
	    		return false;
	    	while (num % 2 == 0)
	    		num /= 2;
	        while (num % 3 == 0)
	        	num /= 3;
	        while (num % 5 == 0)
	        	num /= 5;
	        return (num == 1) ? true : false;
	    }
	    
	    @Test
		public void test() {
	    	Assert.assertEquals(true,isUgly(1));
	    	Assert.assertEquals(true,isUgly(2));
	    	Assert.assertEquals(true,isUgly(3));
	    	Assert.assertEquals(true,isUgly(4));
	    	Assert.assertEquals(true,isUgly(5));
	    	Assert.assertEquals(true,isUgly(6));
	    	Assert.assertEquals(false,isUgly(7));
			Assert.assertEquals(true,isUgly(8));
			Assert.assertEquals(true,isUgly(9));
			Assert.assertEquals(true,isUgly(10));
			Assert.assertEquals(false,isUgly(11));
			Assert.assertEquals(true,isUgly(12));
			Assert.assertEquals(false,isUgly(13));
			Assert.assertEquals(false,isUgly(14));
	    }
}
