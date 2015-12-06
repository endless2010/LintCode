import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

/*
 * ���ʵ��һ�������������ԵĶ���������ĵ�������

 Ԫ�ذ��յ�����˳�򱻷��ʣ��������������
 next()��hasNext()��ѯ�ʲ���Ҫ���̯ʱ�临�Ӷ���O(1)

 �������ж����������ʹ�õ�����������������Ľ��Ϊ [1, 6, 10, 11, 12]

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