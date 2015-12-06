import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * д��һ������ anagram(s, t) ȥ�ж������ַ����Ƿ��ǵߵ���ĸ˳�򹹳ɵ�
 */
public class Anagram {
    public boolean anagram(String s, String t) {
		if (s == null ||t==null ||s.length() != t.length())
			return false;
		char[] sarray=s.toCharArray();
		Arrays.sort(sarray);
		char[] tarray=t.toCharArray();
		Arrays.sort(tarray);
		return Arrays.equals(sarray, tarray);
    }
    @Test
    public void test(){
    	Assert.assertEquals(true,anagram("abcd","bcda"));
    	Assert.assertEquals(true,anagram("abcd ","b cda"));
    	Assert.assertEquals(false,anagram("abcd","bc da"));
    	Assert.assertEquals(false,anagram("abcd","bcdd"));
    	Assert.assertEquals(true,anagram("aaa","aaa"));
    	Assert.assertEquals(false,anagram("ac","bb"));
    	Assert.assertEquals(true,anagram("ab","ba"));
    }
}
