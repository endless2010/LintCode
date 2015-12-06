import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class GenerateParentness {
	public ArrayList<String> generatorPair(int n){
		ArrayList<String> result=new ArrayList<String>();
		if(n<=0)
			return result;
		generatorPair(result,new char[n*2],n,n,0);
		return result;
	}

	private void generatorPair(ArrayList<String> result,char[] chars, int leftRemaining, int rightRemaining, int currentPosition) {
		if(leftRemaining<0 ||rightRemaining<0)
			return;
		if(leftRemaining==0 && rightRemaining==0)
			result.add(new String(chars));
		else{
			if(leftRemaining>0){
				chars[currentPosition]='(';
				generatorPair(result,chars,leftRemaining-1,rightRemaining,currentPosition+1);
			}
			if(rightRemaining>leftRemaining){
				chars[currentPosition]=')';
				generatorPair(result,chars,leftRemaining,rightRemaining-1,currentPosition+1);
			}
		}
	}
	@Test
	public void test(){
		ArrayList<String> list=generatorPair(3);
		Assert.assertEquals(5,list.size());
		Assert.assertTrue(list.contains("((()))"));
		Assert.assertTrue(list.contains("(()())"));
		Assert.assertTrue(list.contains("(())()"));
		Assert.assertTrue(list.contains("()(())"));
		Assert.assertTrue(list.contains("()()()"));
	}
}
