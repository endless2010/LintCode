import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

//TODO:你能使用非递归实现么？
public class PostorderTraveral {
	public ArrayList<Integer> postorderTraversal(TreeNode root){
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(root==null)
			return result;
		 if(root.left!=null)
			 result.addAll(postorderTraversal(root.left));
		 if(root.right!=null)
			 result.addAll(postorderTraversal(root.right)); 
		 result.add(root.val);
		return result;
	}
	@Test
	public void test(){ 
		TreeNode node = TreeNode.createTree(1, 2, 3, 5, 7, null, 9);
		List<Integer> list=postorderTraversal(node);
		Assert.assertEquals(list,Arrays.asList(5,7,2,9,3,1));
	}
}
