import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;


public class MinBTreeDepth {
    public int minDepth(TreeNode root) {
			if (root == null)
				return 0;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			int level=0;
			while (!queue.isEmpty()) {	
				level++;
				int nodes = 0;
				int levelNodes=queue.size();
				while (nodes < levelNodes) {
					TreeNode node = queue.poll();
					if(node.left==null && node.right==null)
						return level;
					if (node.left != null)
						queue.add(node.left);
					if (node.right != null)
						queue.add(node.right);
					nodes++;
				}
			}
			return level;
		}
    @Test
    public void test(){
    	Assert.assertEquals(1,minDepth(TreeNode.createTree(1)));
    	Assert.assertEquals(2,minDepth(TreeNode.createTree(1,2)));
    	Assert.assertEquals(2,minDepth(TreeNode.createTree(1,2,3)));
    	Assert.assertEquals(2,minDepth(TreeNode.createTree(1,2,3,null,null,4,5)));	  
    }
}
