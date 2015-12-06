import org.junit.Assert;
import org.junit.Test;

/*
 * 用 O(1) 时间检测整数 n 是否是 2 的幂次。
 */

public class CheckPowerOf2 {
    public boolean checkPowerOf2(int n) {
        if(n<=0)
        	return false;
        return n==(n&(~n+1));
    }
    @Test
    public void test(){
    	Assert.assertEquals(false,checkPowerOf2(0));
    	Assert.assertEquals(true,checkPowerOf2(1));
    	Assert.assertEquals(true,checkPowerOf2(2));
    	Assert.assertEquals(false,checkPowerOf2(3));
    	Assert.assertEquals(true,checkPowerOf2(4));
    	Assert.assertEquals(false,checkPowerOf2(5));
    }
}
