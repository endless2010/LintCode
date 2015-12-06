import org.junit.Assert;
import org.junit.Test;

/*
 * ����һ������ɾ�������е�����n���ڵ㣬���������ͷ�ڵ㡣
 * ��������1->2->3->4->5->null�� n = 2.
 * ɾ�������ڶ����ڵ�֮������������1->2->3->5->null.
 * ע�������еĽڵ�������ڵ���n
 */
public class RemoveNthFromEnd {
	 ListNode removeNthFromEnd(ListNode head, int n) {
			if(head==null)
				return null;
			ListNode slow=head;
			ListNode fast=head;
			while(n-->0)
				fast=fast.next;
			if(fast==null)
				return slow.next;
			while(fast.next!=null){
				slow=slow.next;
				fast=fast.next;
			}
			slow.next=slow.next.next;
			return head;
	 }
		
		@Test
		public void test(){
			Assert.assertArrayEquals(new int[]{1,2,3,4},removeNthFromEnd(
					ListNode.fromArray(new int[]{1,2,3,4,5}),1).toArray());
			
			Assert.assertArrayEquals(new int[]{1,2,3,5},removeNthFromEnd(
					ListNode.fromArray(new int[]{1,2,3,4,5}),2).toArray());
			
			Assert.assertArrayEquals(new int[]{1,2,4,5},removeNthFromEnd(
					ListNode.fromArray(new int[]{1,2,3,4,5}),3).toArray());
			
			Assert.assertArrayEquals(new int[]{1,3,4,5},removeNthFromEnd(
					ListNode.fromArray(new int[]{1,2,3,4,5}),4).toArray());
			
			Assert.assertArrayEquals(new int[]{2,3,4,5},removeNthFromEnd(
					ListNode.fromArray(new int[]{1,2,3,4,5}),5).toArray());
		}
}
