import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class ValidParentness {
    public boolean isValidParentheses(String s) {
    	if(s==null ||s.length()==0)
    		return true;
    	Stack<Character> stack=new Stack<Character>();
    	for(int i=0;i<s.length();++i){
    		if(isLeft(s.charAt(i)))
    			stack.push(s.charAt(i));
    		else if(stack.isEmpty()||stack.pop()!=getLeft(s.charAt(i)))
    			return false;
    	}
        return stack.isEmpty();
    }

	private Character getLeft(char charAt) {
		switch(charAt){
			case ')':return '(';
			case ']':return '[';
			case '}':return '{';
		}
		return null;
	}

	private boolean isLeft(char charAt) {
		return charAt=='('||charAt=='['||charAt=='{';
	}
	@Test
	public void test(){
		Assert.assertEquals(false,isValidParentheses("}"));
		Assert.assertEquals(false,isValidParentheses("["));
		Assert.assertEquals(true,isValidParentheses("[]"));
		Assert.assertEquals(false,isValidParentheses("[}"));
		Assert.assertEquals(true,isValidParentheses("{[]}"));
		Assert.assertEquals(true,isValidParentheses("()[]{}"));
		Assert.assertEquals(false,isValidParentheses("({)}"));
	}
}