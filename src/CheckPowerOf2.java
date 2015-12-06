import org.junit.Assert;
import org.junit.Test;

/*
 * �� O(1) ʱ�������� n �Ƿ��� 2 ���ݴΡ�
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
