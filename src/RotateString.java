import org.junit.Assert;
import org.junit.Test;

/*
 * ����һ���ַ�����һ��ƫ����������ƫ������ת�ַ���(����������ת)
 * ��ս:��������ԭ����ת��ʹ��O(1)�Ķ���ռ�
 */
public class RotateString {

	public void rotateString(char[] str, int offset) {
		if (offset <= 0 || str==null ||str.length==0)
			return;
		offset%=str.length;
		rotateString(str, 0, str.length - offset-1);
		rotateString(str, str.length-offset, str.length - 1);
		rotateString(str, 0, str.length - 1);
	}

	private void rotateString(char[] str, int from, int to) {
		while(from>=0&&to<str.length&&from<to){
			char temp=str[from];
			str[from]=str[to];
			str[to]=temp;
			++from;
			--to;
		}
	}

	@Test
	public void test() {
		char[] chars1 = "abcdefg".toCharArray();
		rotateString(chars1, 0);
		Assert.assertEquals("abcdefg", new String(chars1));
		char[] chars2 = "abcdefg".toCharArray();
		rotateString(chars2, 1);
		Assert.assertEquals("gabcdef", new String(chars2));
		char[] chars3 = "abcdefg".toCharArray();
		rotateString(chars3, 2);
		Assert.assertEquals("fgabcde", new String(chars3));
		char[] chars4 = "abcdefg".toCharArray();
		rotateString(chars4, 3);
		Assert.assertEquals("efgabcd", new String(chars4));
	}
}
