import org.junit.Assert;
import org.junit.Test;

/*
 * ��������1->2->3->4->5->null�� m = 2 ��n = 4������1->4->3->2->5->null
 * m��n����1 �� m �� n �� ������
 */
public class ReverseBetween {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode mNode = new ListNode(0);
		ListNode pre = dummy, curr = head, next = null;
		for (int i = 1; i <= n; ++i) {
			if (i == m)
				mNode = curr;
			if (i < m)
				pre = pre.next;
			next = curr.next;
			if (i > m && i <= n) {
				mNode.next = next;
				curr.next = pre.next;
				pre.next = curr;
			}
			curr = next;
		}
		return dummy.next;
	}

	@Test
	public void test() {
		ListNode node = reverseBetween(
				ListNode.fromArray(new int[] { 1, 2, 3, 4, 5 }), 2, 4);
		Assert.assertArrayEquals(new int[] { 1, 4, 3, 2, 5 }, node.toArray());
	}
}
