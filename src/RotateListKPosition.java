import org.junit.Assert;
import org.junit.Test;

/*
 * ����һ��������ת����ʹ��ÿ���ڵ������ƶ�k��λ�ã�����k��һ���Ǹ���
 * ��������1->2->3->4->5->6->null��k=2
 * ����5->6->1->2->3->4->null
 */
public class RotateListKPosition {
	 public ListNode rotateRight(ListNode head, int k) {
		 if(head==null || k<=0)
			 return head;
		 
		 ListNode slow=head;
		 ListNode fast=head;
		 int length=0;
		 ListNode temp=head;
		 while(temp!=null){
			 length++;
			 temp=temp.next;
		 }
		 k%=length;
		 for(int i=0;i<k;++i)
			 fast=fast.next;
		 while(fast.next!=null){
			 fast=fast.next;
			 slow=slow.next;
		 }
		 fast.next=head;
		 ListNode newHead=slow.next;
		 slow.next=null;
		 return newHead;
	 }

	 @Test
	 public void test(){
		 Assert.assertArrayEquals(new int[]{5,1,2,3,4},rotateRight(
			   ListNode.fromArray(new int[]{1,2,3,4,5}),1).toArray());

		 Assert.assertArrayEquals(new int[]{4,5,1,2,3},rotateRight(
				   ListNode.fromArray(new int[]{1,2,3,4,5}),2).toArray());
		 
		 Assert.assertArrayEquals(new int[]{3,4,5,1,2},rotateRight(
				   ListNode.fromArray(new int[]{1,2,3,4,5}),3).toArray());
		 
		 Assert.assertArrayEquals(new int[]{2,3,4,5,1},rotateRight(
				   ListNode.fromArray(new int[]{1,2,3,4,5}),4).toArray());
		 
		 Assert.assertArrayEquals(new int[]{1,2,3,4,5},rotateRight(
				   ListNode.fromArray(new int[]{1,2,3,4,5}),5).toArray());
		 
		 Assert.assertArrayEquals(new int[]{5,1,2,3,4},rotateRight(
				   ListNode.fromArray(new int[]{1,2,3,4,5}),6).toArray());
		 
		 Assert.assertArrayEquals(new int[]{4,5,1,2,3},rotateRight(
				   ListNode.fromArray(new int[]{1,2,3,4,5}),7).toArray());
		 
		 Assert.assertArrayEquals(new int[]{3,4,5,1,2},rotateRight(
				   ListNode.fromArray(new int[]{1,2,3,4,5}),8).toArray());

	 }
}
