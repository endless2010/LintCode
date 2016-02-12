import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * 给定一个二叉树，找出所有路径中各节点相加总和等于给定 目标值 的路径。
 * 一个有效的路径，指的是从根节点到叶节点的路径。
 * 给定一个二叉树，和 目标值 = 5:
 1
 / \
 2   4
 / \
 2   3
 返回：

 [
 [1, 2, 2],
 [1, 4]
 ]
 */
public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if (root == null)
			return result;

		helper(root, null, result);
		return result;
	}

	private void helper(TreeNode root, String path, List<String> result) {
		if (path != null)
			path += "->" + root.val;
		else
			path = "" + root.val;
		if (root.left == null && root.right == null) {
			result.add(path);
			return;
		}
		if (root.left != null)
			helper(root.left, path, result);
		if (root.right != null)
			helper(root.right, path, result);
	}

	@Test
	public void test() {
		TreeNode root = TreeNode.createTree(1, 2, 4, 2, 3);
		List<String> list = binaryTreePaths(root);
		for (String str : list)
			System.out.println(str);
	}
}