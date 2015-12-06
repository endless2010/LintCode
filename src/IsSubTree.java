import org.junit.Assert;
import org.junit.Test;

public class IsSubTree {
	public boolean isSubtree(TreeNode T1, TreeNode T2) {
		boolean result = false;
		if (T2 == null) {
			return true;
		}
		if (T1 == null) {
			return false;
		}
		if (T1.val == T2.val) 
			result = isSametree(T1, T2);
		result |= isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
		return result;
	}

	boolean isSametree(TreeNode T1, TreeNode T2) {
		if (T1 != null && T2 != null && T1.val == T2.val) {
			return isSametree(T1.left, T2.left) && isSametree(T1.right, T2.right);
		}
		if (T1 == null && T2 == null) {
			return true;
		}
		return false;
	}

	@Test
	public void test() {
		TreeNode tree11 = TreeNode.createTree(1, 2, 3, 5, 7, null, 9);
		TreeNode tree12 = TreeNode.createTree(2, 5, 7);
		Assert.assertEquals(true, isSubtree(tree11, tree12));

		TreeNode tree21 = TreeNode.createTree(1, 2, 3, 5, 7, null, 9);
		TreeNode tree22 = TreeNode.createTree(1, 2, 3, 5, 6);
		Assert.assertEquals(false, isSubtree(tree21, tree22));

		TreeNode tree31 = TreeNode.createTree(1, 1, 1, 2, 3, 6, 7, null, null,4, 5);
		TreeNode tree32 = TreeNode.createTree(1, 2, 3, null, null, 4, 5);
		Assert.assertEquals(true, isSubtree(tree31, tree32));
	}
}
