import org.junit.Assert;
import org.junit.Test;

/*
 * �ж��������ܰ���ͨ����������͡�*�����ַ����Ƿ�ƥ�䡣ƥ��������£�
'?' ����ƥ���κε����ַ���
'*' ����ƥ�������ַ������������ַ�������
��������ȫƥ�����ƥ��ɹ���
 */
public class RegexMatch {
	public boolean isMatch(String s, String p) {
		return false;
	}

	@Test
	public void test() {
		Assert.assertEquals(false, isMatch("aa", "a"));
		Assert.assertEquals(false, isMatch("aa", "aa"));
		Assert.assertEquals(false, isMatch("aaa", "aa"));
		Assert.assertEquals(false, isMatch("aa", "*"));
		Assert.assertEquals(false, isMatch("aa", "a*"));
		Assert.assertEquals(false, isMatch("ab", "?*"));
		Assert.assertEquals(false, isMatch("aab", "c*a*b"));
	}
}
