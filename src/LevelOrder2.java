import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

/*
 * 给出一棵二叉树，返回其节点值从底向上的层次序遍历（按从叶节点所在层到根节点所在的层遍历，然后逐层从左往右遍历)
 */
public class LevelOrder2 {
	public  ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {		
			int nodes = 0;
			int levelNodes=queue.size();
			ArrayList<Integer> list=new ArrayList<Integer>();
			while (nodes < levelNodes) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
				nodes++;
			}
			result.add(0, list);
		}
		return result;
	}
	@Test
	public void test() {
		TreeNode node = TreeNode.createTree(1, 2, 3, 5, 7, null, 9);
		ArrayList<ArrayList<Integer>> result=levelOrderBottom(node);
		Assert.assertEquals(3,result.size());
		Assert.assertEquals(Arrays.asList(1),result.get(2));
		Assert.assertEquals(Arrays.asList(2,3),result.get(1));
		Assert.assertEquals(Arrays.asList(5,7,9),result.get(0));
	}
}
