import org.junit.Assert;
import org.junit.Test;


public class BuildTreeByInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(inorder==null || postorder==null)
    		return null;
    	int rootValue=postorder[postorder.length-1];
    	TreeNode root=new TreeNode(rootValue);
    	return root;
    }
    
    @Test
    public void test(){
    	TreeNode root=buildTree(new int[]{1,2,3},new int[]{1,3,2});
    	Assert.assertEquals(2,root.val);
    	Assert.assertEquals(2,root.left.val);
    	Assert.assertEquals(2,root.right.val);
    }
}
