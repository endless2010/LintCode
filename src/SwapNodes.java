import org.junit.Assert;
import org.junit.Test;

/**
 * ����һ�������Լ�����Ȩֵv1��v2������������ȨֵΪv1��v2���������ڵ㡣��֤�����нڵ�Ȩֵ������ͬ�����û���ҵ���Ӧ�ڵ㣬��ôʲôҲ��������
 * ����Ҫ���������ڵ�����Ǹı�ڵ��Ȩֵ
 * �������� 1->2->3->4->null ���Լ� v1 = 2 �� v2 = 4 ���ؽ��
 * 1->4->3->2->null��
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
