import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * ����һ�����������ҳ�����·���и��ڵ�����ܺ͵��ڸ��� Ŀ��ֵ ��·����
 * һ����Ч��·����ָ���ǴӸ��ڵ㵽Ҷ�ڵ��·����
 * ����һ������������ Ŀ��ֵ = 5:
 1
 / \
 2   4
 / \
 2   3
 ���أ�

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