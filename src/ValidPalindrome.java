import org.junit.Assert;
import org.junit.Test;


public class ValidPalindrome {

    public boolean isPalindrome(String s) {
		if(s==null ||s.length()==0)
			return true;
		int start=0;
		int end=s.length()-1;
		s=s.toUpperCase();
		while(start<end){
			if(!Character.isLetterOrDigit(s.charAt(start))){
				++start;
				continue;
			}
			if(!Character.isLetterOrDigit(s.charAt(end))){
				--end;
				continue;
			}
		if(s.charAt(start)!=s.charAt(end))
			return false;
			++start;
			--end;
		}
		return true;
	}

	 @Test
	public void test(){
		Assert.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
		Assert.assertFalse(isPalindrome("race a car"));
	}
}
