import org.junit.Assert;
import org.junit.Test;

public class ValidNumber {
	public boolean isNumber(String s) {
		if (s == null || s.trim().length()==0)
			return false;
		boolean hasSign=false, hasExp=false, hasDot=false, digitsAppeared=false;
		s=s.trim();
		for (int i = 0; i < s.length(); ++i) {
			switch (s.charAt(i)) {
				case '+':
				case '-':
					if(hasSign||(i!=0)||(i==s.length()-1))
						return false;
					hasSign=true;
					break;
				case '.':
					if(hasDot||s.length()==1 ||(s.length()==2 &&hasSign)||(i>0 &&(s.charAt(i-1)=='E'||s.charAt(i-1)=='e')))
						return false;
					hasDot=true;
					break;
				case 'E':
				case 'e':
					if(hasExp||i==0||i==s.length()-1||!digitsAppeared)
						return false;
					hasExp=true;
					break;
				default:
					if(Character.isDigit(s.charAt(i)))
						digitsAppeared=true;
					else
						return false;
					break;
			}
		}
		return true;
	}
	
	@Test
	public void test(){
		Assert.assertEquals(true,isNumber("2.3"));
		Assert.assertEquals(true,isNumber("+2.3"));
		Assert.assertEquals(false,isNumber("-2 .3"));
		Assert.assertEquals(true,isNumber("2.3E2"));
		Assert.assertEquals(false,isNumber("2.3E2.1"));
		Assert.assertEquals(true,isNumber("+2.3E2"));
		Assert.assertEquals(false,isNumber("2.3+E2"));
		Assert.assertEquals(false,isNumber("+2.3E2."));
		Assert.assertEquals(true,isNumber(".5"));
		Assert.assertEquals(true,isNumber("+0"));
		Assert.assertEquals(false,isNumber("E2"));
	}
}