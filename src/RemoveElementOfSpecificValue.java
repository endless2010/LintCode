import org.junit.Assert;
import org.junit.Test;

/*
 * remove all elements from a linked list of integers that have value val.
 * Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5
 */
public class RemoveElementOfSpecificValue {
    public ListNode removeElements(ListNode head, int val) {
       if(head==null)
    	   return head;
       while(head!=null &&head.val==val){
    	   head=head.next;
       }
       if(head==null ||head.next==null)
    	   return head;
       ListNode prev=head;
       ListNode curr=prev.next;
       while(curr!=null){
    	   if(curr.val!=val)
    		   prev=curr;
    	   else
    		   prev.next=curr.next;
    	   
		   curr=curr.next;
       }
       return head;
    }
    @Test
    public void test(){
    	ListNode node=ListNode.fromArray(new int[]{1,1});
    	Assert.assertTrue(removeElements(node,1)==null);
    	
		ListNode node1=ListNode.fromArray(new int[]{3,3,3,4});
		Assert.assertArrayEquals(new int[]{4},removeElements(node1,3).toArray());
		
		ListNode node2=ListNode.fromArray(new int[]{2,3,3,4});
		Assert.assertArrayEquals(new int[]{2,4},removeElements(node2,3).toArray());
		
		ListNode node3=ListNode.fromArray(new int[]{2,3,4,4,4});
		Assert.assertArrayEquals(new int[]{2,3},removeElements(node3,4).toArray());
		
		ListNode node4=ListNode.fromArray(new int[]{2,3,4,4,4});
		Assert.assertArrayEquals(new int[]{2,4,4,4},removeElements(node4,3).toArray());
		
		ListNode node5=ListNode.fromArray(new int[]{2,3,4,4,4});
		Assert.assertArrayEquals(new int[]{2,3,4,4,4},removeElements(node5,1).toArray());
    }
}
