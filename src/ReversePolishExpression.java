import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/*
 * Reverse Polish Notation
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class ReversePolishExpression {
	
	public int evalRPN(String[] tokens){
		if(tokens==null || tokens.length==0)
			return 0;
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=0;i<tokens.length;++i){
			if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
				int right=stack.pop();
				int left=stack.pop();
				stack.push(cal(left,right,tokens[i]));
			}			
			else
				stack.push(Integer.parseInt(tokens[i]));
		}
		return stack.pop();
	}
	private int cal(int left, int right, String operator) {
		if(operator.equals("+"))	return left+right;
		if(operator.equals("-"))	return left-right;
		if(operator.equals("*"))	return left*right;
		if(operator.equals("/"))	return left/right;
		return Integer.MIN_VALUE;
	}
	@Test
	public void test(){
		Assert.assertEquals(9,evalRPN(new String[]{"2","1","+","3","*"}));
		Assert.assertEquals(2,evalRPN(new String[]{"6","3","/"}));
		Assert.assertEquals(6,evalRPN(new String[]{"4", "13", "5", "/", "+"}));
	}
}