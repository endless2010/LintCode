import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/*
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.
 *         
              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6
 */
public class FlattenBTreeToList {
	public void flatten(TreeNode root) {
		if (root == null)
			return;
		List<TreeNode> list = new ArrayList<TreeNode>();
		preorder(root, list);
		for (int i = 0; i < list.size(); i++) {
			root.val = list.get(i).val;
			if (i < list.size() - 1) {
				root.left = null;
				root.right = new TreeNode(0);;
				root = root.right;
			}
		}
	}

	private void preorder(TreeNode root, List<TreeNode> list) {
		if (root == null)
			return;
		list.add(root);
		preorder(root.left, list);
		preorder(root.right, list);
	}
	@Test
	public void test(){
		TreeNode root=TreeNode.createTree(1,2,5,3,4,null,6);
		flatten(root);
		Assert.assertEquals(1,root.val);Assert.assertTrue(root.left==null);Assert.assertEquals(2,root.right.val);
		root=root.right;
		Assert.assertEquals(2,root.val);Assert.assertTrue(root.left==null);Assert.assertEquals(3,root.right.val);
		root=root.right;
		Assert.assertEquals(3,root.val);Assert.assertTrue(root.left==null);Assert.assertEquals(4,root.right.val);
		root=root.right;
		Assert.assertEquals(4,root.val);Assert.assertTrue(root.left==null);Assert.assertEquals(5,root.right.val);
		root=root.right;
		Assert.assertEquals(5,root.val);Assert.assertTrue(root.left==null);Assert.assertEquals(6,root.right.val);
		root=root.right;
		Assert.assertEquals(6,root.val);Assert.assertTrue(root.left==null);Assert.assertTrue(root.right==null);
	}
}
