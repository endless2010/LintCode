import org.junit.Assert;
import org.junit.Test;

public class NthToLast {
	public ListNode nthToLast(ListNode head,int n){
		if(head==null)
			return null;
		ListNode slow=head;
		ListNode fast=head;
		while(n-->1)
			fast=fast.next;
		while(fast.next!=null){
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	
	@Test
	public void test(){
		Assert.assertEquals(1,nthToLast(ListNode.fromArray(new int[]{1}),1).val);
		Assert.assertEquals(5,nthToLast(ListNode.fromArray(new int[]{1,2,3,4,5}),1).val);
		Assert.assertEquals(4,nthToLast(ListNode.fromArray(new int[]{1,2,3,4,5}),2).val);
		Assert.assertEquals(3,nthToLast(ListNode.fromArray(new int[]{1,2,3,4,5}),3).val);
		Assert.assertEquals(2,nthToLast(ListNode.fromArray(new int[]{1,2,3,4,5}),4).val);
		Assert.assertEquals(1,nthToLast(ListNode.fromArray(new int[]{1,2,3,4,5}),5).val);
	}
}