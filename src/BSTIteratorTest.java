import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/*
 * 设计实现一个带有下列属性的二叉查找树的迭代器：

 元素按照递增的顺序被访问（比如中序遍历）
 next()和hasNext()的询问操作要求均摊时间复杂度是O(1)

 对于下列二叉查找树，使用迭代器进行中序遍历的结果为 [1, 6, 10, 11, 12]

 	  10
 	 /  \
 	6    11
   /      \
  1        12
 */
public class BSTIteratorTest {

    public class BSTIterator {
    	Stack<TreeNode> stack=new Stack<TreeNode>();
    	
    	public BSTIterator(TreeNode root) {
    		enqueue(root);
    	}
    	public boolean hasNext() {
    		return !stack.isEmpty();
    	}

    	public TreeNode next() {
    		TreeNode node=stack.pop();
    		enqueue(node.right);
    		return node;
    	}
    	
    	private void enqueue(TreeNode root){
    		while(root!=null){
    			stack.push(root);
    			root=root.left;
    		}
    	}
    }
    @Test
    public void test(){
    	TreeNode root=TreeNode.createTree(6,4,8,3,5);
    	BSTIterator iter=new BSTIterator(root);
    	Assert.assertEquals(true,iter.hasNext());Assert.assertEquals(3,iter.next().val);
    	Assert.assertEquals(true,iter.hasNext());Assert.assertEquals(4,iter.next().val);
    	Assert.assertEquals(true,iter.hasNext());Assert.assertEquals(5,iter.next().val);
    	Assert.assertEquals(true,iter.hasNext());Assert.assertEquals(6,iter.next().val);
    	Assert.assertEquals(true,iter.hasNext());Assert.assertEquals(8,iter.next().val);
    	Assert.assertEquals(false,iter.hasNext());
    }
}