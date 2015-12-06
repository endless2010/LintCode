import org.junit.Assert;
import org.junit.Test;

/*
 * ����һ��������ת����ʹ��ÿ���ڵ������ƶ�k��λ�ã�����k��һ���Ǹ���
 * ��������1->2->3->4->5->null��k=2
 * ����4->5->1->2->3->null
 */
public class RotateListKPosition {
	 public ListNode rotateRight(ListNode head, int k) {
		 return null;
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
				   ListNode.fromArray(new int[]{2,3,4,5,1}),6).toArray());
		 
		 Assert.assertArrayEquals(new int[]{4,5,1,2,3},rotateRight(
				   ListNode.fromArray(new int[]{3,4,5,1,2}),7).toArray());
		 
		 Assert.assertArrayEquals(new int[]{3,4,5,1,2},rotateRight(
				   ListNode.fromArray(new int[]{3,4,5,1,2}),8).toArray());

	 }
}
