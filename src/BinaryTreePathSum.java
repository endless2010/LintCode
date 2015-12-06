import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
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
public class BinaryTreePathSum {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
    	List<List<Integer>> result=new ArrayList<List<Integer>>();
    	pathsum(root,target,result);
    	return null;
    }

	private void pathsum(TreeNode root, int target, List<List<Integer>> result) {
		if(root.left==null && root.right==null)
			return;
		
	}
	@Test
	public void test(){
		TreeNode root=TreeNode.createTree(1,2,4,2,3);
		List<List<Integer>> list=binaryTreePathSum(root,5);
		Assert.assertEquals(2,list.size());
		Assert.assertEquals(list.get(0),Arrays.asList(1,2,2));
		Assert.assertEquals(list.get(1),Arrays.asList(1,4));
	}
}
