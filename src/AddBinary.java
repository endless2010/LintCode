import org.junit.Assert;
import org.junit.Test;


public class AddBinary {
	public String addBinary(String a, String b) {
		if (a == null || a.length() == 0)
			return b;
		if (b == null || b.length() == 0)
			return a;
		if(a.length()<b.length()){
			String temp=a;
			a=b;
			b=temp;
		}
		if (b.length() < a.length()) {
			StringBuilder sbTemp = new StringBuilder(b);
			while (sbTemp.length() < a.length())
				sbTemp.insert(0, '0');
			b = sbTemp.toString();
		}
		int index = a.length() - 1;
		StringBuilder sb = new StringBuilder();
		int flag = 0;
		while (index >= 0) {
			int value = a.charAt(index) - '0' + b.charAt(index) - '0'
					+ flag;
			if (value >= 2) {
				sb.insert(0, value - 2);
				flag = 1;
			} else {
				sb.insert(0, value);
				flag=0;
			}
			--index;
		}
		if (flag > 0)
			sb.insert(0, '1');
		return sb.toString();
	}

	@Test
	public void test() {
		Assert.assertEquals("111", addBinary("101", "010"));
		Assert.assertEquals("1000", addBinary("111", "1"));
		Assert.assertEquals("1000", addBinary("1", "111"));
		Assert.assertEquals("11011", addBinary("1101", "1110"));
		Assert.assertEquals("10101", addBinary("1010", "1011"));

	}
}
