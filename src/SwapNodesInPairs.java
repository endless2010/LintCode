import org.junit.Assert;
import org.junit.Test;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.
 * Challenge:Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
    	if(head==null ||head.next==null)
    		return head;
    	ListNode first=head;
    	ListNode second=first.next;
    	first.next=swapPairs(second.next);
    	second.next=first;
    	return second;
    }
    
    @Test
    public void test(){
		ListNode node1=swapPairs(ListNode.fromArray(new int[]{1,3,5}));
		Assert.assertArrayEquals(new int[]{3,1,5},node1.toArray());
		
		ListNode node2=swapPairs(ListNode.fromArray(new int[]{1,3,5,7}));
		Assert.assertArrayEquals(new int[]{3,1,7,5},node2.toArray());
		
		ListNode node3=swapPairs(ListNode.fromArray(new int[]{1}));
		Assert.assertArrayEquals(new int[]{1},node3.toArray());
    }
}
