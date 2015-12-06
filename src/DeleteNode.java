import junit.framework.Assert;

import org.junit.Test;

/*
 * ����һ���������еı�ͷ��һ���ȴ���ɾ���Ľڵ�(�Ǳ�ͷ���β)��
 * ������O(1)ʱ�临�Ӷ�ɾ��������ڵ㡣����ɾ���ýڵ�󣬷��ر�ͷ��
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
