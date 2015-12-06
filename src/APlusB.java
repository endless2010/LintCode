import org.junit.Assert;
import org.junit.Test;

public class APlusB {
	//http://blog.csdn.net/wangyuquanliuli/article/details/47755461
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        if(a==0)return b;  
        if(b==0)return a;  
        int x1 = a^b;  
        int x2 = (a&b)<<1;  
        return aplusb(x1,x2); 
	}

	@Test
	public void test() {
		Assert.assertEquals(5, aplusb(2, 3));
		Assert.assertEquals(-5, aplusb(-2, -3));
		Assert.assertEquals(-5, aplusb(-2, -3));
		Assert.assertEquals(-1, aplusb(2, -3));
		Assert.assertEquals(1, aplusb(-2, 3));
		Assert.assertEquals(357, aplusb(123, 234));
	}

}
