import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一棵二叉树(Binary Search Tree)，找到两个节点的最近公共父节点(LCA)。
 * https://leetcode.com/discuss/63165/clean-java-ac-solution-13ms-with-explanation
 */
public class LowestCommonAncester {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {  
		if(root == null)
	        return null ;
	    TreeNode left = lowestCommonAncestor(root.left, A, B);
	    TreeNode right = lowestCommonAncestor(root.right, A, B);

	    if(root == A || root == B)
	        return root;

	    if(left != null && right == null)
	        return left;
	    else if(left == null && right != null)
	        return right;
	    else if(left == null && right == null)
	        return null;
	    else
	        return root;
    }  
    
	  @Test
	  public void test(){
		  TreeNode root=TreeNode.createTree(4,2,6,1,3,5,7);
		  Assert.assertEquals(4,lowestCommonAncestor(root,root.left,root.right).val);
		  Assert.assertEquals(2,lowestCommonAncestor(root,root.left,root.left.right).val);
		  Assert.assertEquals(4,lowestCommonAncestor(root,root.left,root.right.left).val);
	  }
}
