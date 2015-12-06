import org.junit.Assert;
import org.junit.Test;

public class HasCycle {
    public boolean hasCycle(ListNode head) {  
        if(head==null ||head.next==null)
        	return false;
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null){
        	if(fast.next==slow)
        		return true;
        	slow=slow.next;
        	fast=fast.next;
        	if(fast!=null)
        		fast=fast.next;
        }
        return false;
    }
    
    @Test
    public void test(){
    	ListNode root1=new ListNode(1);ListNode node2=new ListNode(2);
    	ListNode node3=new ListNode(3);ListNode node4=new ListNode(4);
    	root1.next=node2;node2.next=node3;node3.next=node4;node4.next=node2;
    	Assert.assertEquals(true,hasCycle(root1));
    	node4.next=null;
    	Assert.assertEquals(false,hasCycle(root1));
    }
}