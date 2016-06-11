import org.junit.Assert;
import org.junit.Test;

/**
 * 给你一个链表以及两个权值v1和v2，交换链表中权值为v1和v2的这两个节点。保证链表中节点权值各不相同，如果没有找到对应节点，那么什么也不用做。
 * 你需要交换两个节点而不是改变节点的权值
 * 给出链表 1->2->3->4->null ，以及 v1 = 2 ， v2 = 4 返回结果
 * 1->4->3->2->null。
 */
public class SwapNodes {
	public ListNode swapNodes(ListNode head, int v1, int v2) {
		return head;
	}

	@Test
	public void test() {
		ListNode node1 = swapNodes(ListNode.fromArray(new int[] { 1, 2, 3, 4 }), 2, 4);
		Assert.assertArrayEquals(new int[] { 1, 4, 3, 2 }, node1.toArray());
		
		ListNode node2 = swapNodes(ListNode.fromArray(new int[] { 1, 2, 3 }), 2, 2);
		Assert.assertArrayEquals(new int[] { 1, 2, 3 }, node2.toArray());
		
		ListNode node3 = swapNodes(ListNode.fromArray(new int[] { 10, 8, 7, 6, 4, 3}), 8, 10);
		Assert.assertArrayEquals(new int[] { 8, 10, 7, 6, 4, 3 }, node3.toArray());
	}
}
