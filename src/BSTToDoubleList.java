import java.util.ArrayList;

import org.junit.Test;

/*
 * 将一个二叉查找树按照中序遍历转换成双向链表。
 */
public class BSTToDoubleList {
	public ArrayList<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> result=new ArrayList<Integer>();
		if(root==null)
			return result;
		 if(root.left!=null)
			 result.addAll(inorderTraversal(root.left));
		 result.add(root.val);
		 if(root.right!=null)
			 result.addAll(inorderTraversal(root.right));
		return result;
	}
    public DoublyListNode bstToDoublyList(TreeNode root) {  
		if(root==null)
			return null;
		ArrayList<Integer> list=inorderTraversal(root);
		DoublyListNode head=new DoublyListNode(list.get(0));
		DoublyListNode temp=head;
		for(int i=1;i<list.size();++i){
			temp.next=new DoublyListNode(list.get(i));
			temp.next.prev=temp;
			temp=temp.next;
		}
		return head;
    }
    
    @Test
    public void test(){
    	TreeNode root=TreeNode.createTree(4,2,5,1,3);
    	System.out.println(bstToDoublyList(root));
    }
}
