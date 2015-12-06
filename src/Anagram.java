import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/*
 * 写出一个函数 anagram(s, t) 去判断两个字符串是否是颠倒字母顺序构成的
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
