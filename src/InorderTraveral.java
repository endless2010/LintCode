import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

//TODO:你能使用非递归实现么？
public class InorderTraveral {
	public ArrayList<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(root==null)
			return result;
		 if(root.left!=null)
			 result.addAll(inorderTraversal(root.left));
		 result.add(root.val);
		 if(root.right!=null)
			 result.addAll(inorderTraversal(root.right));
		return result;
	}
	@Test
	public void test(){ 
		TreeNode node = TreeNode.createTree(1, 2, 3, 5, 7, null, 9);
		List<Integer> list=inorderTraversal(node);
		Assert.assertEquals(list,Arrays.asList(5,2,7,1,3,9));
	}
}
