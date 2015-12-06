import org.junit.Assert;
import org.junit.Test;

/*
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 *  return the length of last word in the string.
 *  If the last word does not exist, return 0.
 */
public class LengthOfLastWord {
	
	public int lengthOfLastWord(String s) {
		if(s==null || s.length()==0)
			return 0;
		String trimStr=s.trim();
		if(trimStr.length()==0)
			return 0;
		int lastNonSpaceIndex=trimStr.lastIndexOf(' ');
		if(lastNonSpaceIndex==-1)
			return trimStr.length();
		else
			return trimStr.length()-1-lastNonSpaceIndex;		
	}

	@Test
	public void test() {
		Assert.assertEquals(10, lengthOfLastWord("HelloWorld"));
		Assert.assertEquals(5, lengthOfLastWord("Hello World"));
		Assert.assertEquals(3, lengthOfLastWord("Hello World have Fun"));
		Assert.assertEquals(0, lengthOfLastWord("  "));
		Assert.assertEquals(5, lengthOfLastWord("  Hello"));
		Assert.assertEquals(5, lengthOfLastWord("Hello  "));
		Assert.assertEquals(5, lengthOfLastWord("  Hello  "));
		Assert.assertEquals(0, lengthOfLastWord(null));
		Assert.assertEquals(0, lengthOfLastWord(""));

	}
}
