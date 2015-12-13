import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/*
 * Write an algorithm to determine if a number is happy.
 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the sum of the squares of its digits, 
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1. 
 * Those numbers for which this process ends in 1 are happy numbers
 * 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {
	public boolean isHappy(int n) {
		if (n <= 0 )
			return false;
		Set<Integer> set=new HashSet<Integer>();	
		while (true) {
			int squares = 0;
			while (n > 0) {
				squares += (n % 10)*(n % 10);
				n /= 10;
			}
			if(squares==1)
				return true;
			if(set.contains(squares))
				return false;
			set.add(squares);
			n=squares;
		}
	}

	@Test
	public void test(){
		Assert.assertEquals(isHappy(1),true);
		Assert.assertEquals(isHappy(3),false);
		Assert.assertEquals(isHappy(7),true);
		Assert.assertEquals(isHappy(18),false);
		Assert.assertEquals(isHappy(19),true);
	}
}
