import org.junit.Assert;
import org.junit.Test;

//TODO:递归固然可行，能否写个非递归的？
public class InvertBinaryTree {
	   public void invertBinaryTree(TreeNode root) {
	        if(root==null ||(root.left==null&&root.right==null))
	        	return;
	        TreeNode temp=root.left;
	        root.left=root.right;
	        root.right=temp;
	        if(root.left!=null)
	        	invertBinaryTree(root.left);
	        if(root.right!=null)
	        	invertBinaryTree(root.right);
	    }
	    @Test
	    public void Test(){
	    	TreeNode root = TreeNode.createTree(1, 2, 7, 1, 3, 6, 9);
	    	invertBinaryTree(root);
	    	Assert.assertEquals(root,TreeNode.createTree(1, 7, 2, 9, 6, 3, 1));
	    }
}
