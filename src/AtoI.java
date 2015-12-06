import org.junit.Assert;
import org.junit.Test;

/*
 * 功 能: 跳过前面的空格字符，直到遇上数字或正负号才开始做转换，
 * 而再遇到非数字或字符串时（'\0'）才结束转化，并将结果返回（返回转换后的整型数）。
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
