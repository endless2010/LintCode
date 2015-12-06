import org.junit.Assert;
import org.junit.Test;

/*
 * �� ��: ����ǰ��Ŀո��ַ���ֱ���������ֻ������Ųſ�ʼ��ת����
 * �������������ֻ��ַ���ʱ��'\0'���Ž���ת��������������أ�����ת���������������
 */
public class AtoI {
	public int atoi(String str) {
		double result = 0;
		boolean positive = true;
		boolean found=false;//+ - can only appear once
		int i=0;
		while(i<str.length() && str.charAt(i)==' ')
			++i;
		boolean first=true;
		while (i < str.length()){
				if (str.charAt(i) == '+' && !found && first){
					positive = true;
					found=true;
				}else if (str.charAt(i) == '-' && !found && first){
					positive = false;
					found=true;
				}else if (Character.isDigit(str.charAt(i)))
					result = result * 10 + str.charAt(i) - '0';
				else
					break;
			++i;
			first=false;
		}
		if(!positive)
			result=-result;
		if(result>Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		else if(result<Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int)result;
	}

	@Test
	public void test() {
		Assert.assertEquals(123, atoi("123"));
		Assert.assertEquals(123, atoi("+123"));
		Assert.assertEquals(-123, atoi("-123"));
		Assert.assertEquals(123, atoi("   123"));
		Assert.assertEquals(123, atoi("123X"));
		Assert.assertEquals(123, atoi("123.3"));
		Assert.assertEquals(0, atoi("abc"));
		Assert.assertEquals(0, atoi("+-2"));
		Assert.assertEquals(15, atoi(" 15+4"));
		Assert.assertEquals(Integer.MAX_VALUE, atoi(Integer.MAX_VALUE+""));
		Assert.assertEquals(Integer.MIN_VALUE, atoi(Integer.MIN_VALUE+""));
	}

}
