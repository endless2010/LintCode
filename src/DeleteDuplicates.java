import org.junit.Assert;
import org.junit.Test;

/*
 * 给定一个排序链表，删除所有重复的元素每个元素只留下一个。
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head==null) return null;
    	ListNode current=head;
    	ListNode next;
    	while(current!=null &&(next=current.next)!=null){
    		while(next!=null &&current.val==next.val){
    			next=next.next;
    		}
    		current.next=next;
    		current=next;
    	}
        return head;
    }
    @Test
    public void test(){
    	ListNode head=new ListNode(1);
    	head.next=new ListNode(1);
    	head.next.next=new ListNode(1);
    	head=deleteDuplicates(head);
    	Assert.assertEquals(1,head.val);
    	Assert.assertEquals(null,head.next);
    	
    	ListNode head1=new ListNode(1);
    	head1.next=new ListNode(2);
    	head1.next.next=new ListNode(2);
    	head1=deleteDuplicates(head1);
    	Assert.assertEquals(1,head1.val);
    	Assert.assertEquals(2,head1.next.val);
    	Assert.assertEquals(null,head1.next.next);
    	
    	ListNode head2=new ListNode(1);
    	head2.next=new ListNode(1);
    	head2.next.next=new ListNode(2);
    	head2.next.next.next=new ListNode(2);
    	head2.next.next.next.next=new ListNode(3);
    	head2=deleteDuplicates(head2);
    	Assert.assertEquals(1,head2.val);
    	Assert.assertEquals(2,head2.next.val);
    	Assert.assertEquals(3,head2.next.next.val);
    	Assert.assertEquals(null,head2.next.next.next);
    }
}
