import org.junit.Assert;
import org.junit.Test;

/*
 * 根据前序遍历和中序遍历树构造二叉树.
 * 你可以假设树中不存在相同数值的节点
 * 
 */
public class BuildTreeByPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, inorder, 0, inorder.length - 1);
    }
 
    private TreeNode buildTree(int[] preorder, int p, int[] inorder, int low, int high) {
        if (low > high) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[p]);
        int cutPos = 0;
        for (int i = low; i <= high; ++i) {
            if (preorder[p] == inorder[i]) {
                cutPos = i;
                break;
            }
        }
        root.left = buildTree(preorder, p + 1, inorder, low, cutPos - 1);
        root.right = buildTree(preorder, p + cutPos - low + 1, inorder, cutPos + 1,high);
        return root;
    }
    @Test
    public void test(){
    	TreeNode node=buildTree(new int[]{1,2,3},new int[]{2,1,3});
    	Assert.assertTrue(node.val==1);
    	Assert.assertTrue(node.left.val==2);
    	Assert.assertTrue(node.right.val==3);
    	Assert.assertTrue(node.left.left==null && node.left.right==null);
    	Assert.assertTrue(node.right.left==null && node.right.right==null);
    }
}
