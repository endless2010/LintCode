import org.junit.Assert;
import org.junit.Test;

/**
 * дһ�����������һ�������ǲ��ǳ�����
 * �����Ķ����ǣ�ֻ���������� 2, 3, 5 �������������� 6, 8 ���ǳ��������� 14 ���ǳ�����Ϊ�������������� 7��
 * ������Ϊ 1 ��һ������ĳ�����
 * 
 * ���� num = 8������ true��
 * ���� num = 14������ false��
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
