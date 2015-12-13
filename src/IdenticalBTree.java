import org.junit.Assert;
import org.junit.Test;

/*
 * Check if two binary trees are identical. 
 * Identical means the two binary trees have the same structure and every identical position has the same value.
 */
public class IdenticalBTree {
    public boolean isIdentical(TreeNode a, TreeNode b) {
        if(a==null)
        	return b==null;
        if(b==null)
        	return a==null;
        if(a.val!=b.val)
        	return false;
        return isIdentical(a.left,b.left) && isIdentical(a.right,b.right);
    }
    @Test
    public void test(){
    	Assert.assertFalse(isIdentical(null,TreeNode.createTree(1)));
    	Assert.assertFalse(isIdentical(TreeNode.createTree(1),null));
    	Assert.assertFalse(isIdentical(TreeNode.createTree(1,2,3),TreeNode.createTree(1,3,2)));
    	Assert.assertTrue(isIdentical(TreeNode.createTree(1,2),TreeNode.createTree(1,2)));
    }
}
