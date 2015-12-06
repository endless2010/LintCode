import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class IsValidBST {
	public List<Integer> inorder(TreeNode root){
		List<Integer> result=new ArrayList<Integer>();
		if(root==null)
			return result;
		 if(root.left!=null)
			 result.addAll(inorder(root.left));
		 result.add(root.val);
		 if(root.right!=null)
			 result.addAll(inorder(root.right));
		return result;
	}

	public boolean isValidBST(TreeNode root){
		List<Integer> list=inorder(root);
		for(int i=1;i<list.size();++i)
			if(list.get(i)<=list.get(i-1))
				return false;
		return true;
	}
	@Test
	public void test(){ 
		TreeNode node1 = TreeNode.createTree(1, 2, 3, 5, 7, null, 9);
		Assert.assertEquals(false,isValidBST(node1));
		TreeNode node2 = TreeNode.createTree(3,2,5,1,null,4,8);
		Assert.assertEquals(true,isValidBST(node2));
	}
}
