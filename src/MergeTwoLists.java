import org.junit.Assert;
import org.junit.Test;

public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode l1,ListNode l2){
		if(l1==null)	return l2;
		if(l2==null) return l1;
		ListNode head = null;
		ListNode current = null;
		while(l1!=null && l2!=null){
			ListNode temp;
			if(l1.val<=l2.val){
				temp=l1;
				l1=l1.next;
			}else{
				temp=l2;
				l2=l2.next;
			}
			if(head==null){
				head=temp;
				current=temp;
			}else{
				current.next=temp;
				current=current.next;
			}
		}
		if(l1!=null)
			current.next=l1;
		if(l2!=null)
			current.next=l2;
		return head;
	}
	@Test
	public void test(){
		ListNode node1=ListNode.fromArray(new int[]{2,4,6});
		ListNode node2=ListNode.fromArray(new int[]{1,3,5});
		Assert.assertArrayEquals(new int[]{1,2,3,4,5,6},mergeTwoLists(node1,node2).toArray());
		
		ListNode node3=ListNode.fromArray(new int[]{2,4,6});
		Assert.assertArrayEquals(new int[]{2,4,6},mergeTwoLists(node3,null).toArray());
		
		ListNode node5=ListNode.fromArray(new int[]{2,4,6,8,9});
		ListNode node6=ListNode.fromArray(new int[]{1,3,5});
		Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,8,9},mergeTwoLists(node5,node6).toArray());
		
		ListNode node7=ListNode.fromArray(new int[]{2,4});
		ListNode node8=ListNode.fromArray(new int[]{1,3,5});
		Assert.assertArrayEquals(new int[]{1,2,3,4,5},mergeTwoLists(node7,node8).toArray());
	}
}