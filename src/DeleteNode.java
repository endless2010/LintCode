import junit.framework.Assert;

import org.junit.Test;

/*
 * 给定一个单链表中的表头和一个等待被删除的节点(非表头或表尾)。
 * 请在在O(1)时间复杂度删除该链表节点。并在删除该节点后，返回表头。
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
    	node.val=node.next.val;
    	node.next=node.next.next;
    }
	@Test
	public void test() {
		ListNode node1 = new ListNode(2);
		node1.next = new ListNode(4);
		node1.next.next = new ListNode(3);
		deleteNode(node1.next);
		Assert.assertEquals(2, node1.val);
		Assert.assertEquals(3, node1.next.val);
	}
}
