import org.junit.Test;


public class ReverseList {
	
	public ListNode reverse(ListNode head) {
		if(head==null ||head.next==null)
			return head;
		ListNode reversedHead=null;
		ListNode prev=null;
		ListNode current=head;
		while(current!=null){
			if(current.next==null)
				reversedHead=current;
			ListNode next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		return reversedHead;
	}


	@Test
	public void test() {
		ListNode node1 = new ListNode(2);
		node1.next = new ListNode(4);
		node1.next.next = new ListNode(3);
		System.out.println(reverse(node1));
		System.out.println(reverse(new ListNode(3)));
	}
}
