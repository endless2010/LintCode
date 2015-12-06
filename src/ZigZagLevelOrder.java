import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

/*
 * ����һ�ö�������������ڵ�ֵ�ľ���β�α������ȴ������ң���һ���ٴ������󣬲����֮�佻����У�
 */
public class ZigZagLevelOrder {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		boolean reverse=false;
		while (!queue.isEmpty()) {		
			int nodes = 0;
			int levelNodes=queue.size();
			ArrayList<Integer> list=new ArrayList<Integer>();
			while (nodes < levelNodes) {
				TreeNode node = queue.poll();
				if(!reverse)
					list.add(node.val);
				else
					list.add(0, node.val);		
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
				nodes++;
			}
			result.add(list);
			reverse=!reverse;
		}
		return result;
    }

	@Test
	public void test() {
		TreeNode node = TreeNode.createTree(1, 2, 3, 5, 7, null, 9);
		ArrayList<ArrayList<Integer>> result=zigzagLevelOrder(node);
		Assert.assertEquals(3,result.size());
		Assert.assertEquals(Arrays.asList(1),result.get(0));
		Assert.assertEquals(Arrays.asList(3,2),result.get(1));
		Assert.assertEquals(Arrays.asList(5,7,9),result.get(2));
	}
}
