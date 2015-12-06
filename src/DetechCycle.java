import java.util.HashSet;
import java.util.Set;

import junit.framework.Assert;

import org.junit.Test;

/*
 * TODO 挑战:不使用额外的空间
 */
public class DetechCycle {
    public ListNode detectCycle(ListNode head) {  
    	ListNode temp=head;
    	Set<ListNode> set=new HashSet<ListNode>();
    	while(temp!=null){
    		if(set.contains(temp))
    			return temp;
    		set.add(temp);
    		temp=temp.next;
    	}
    	return null;
    }
    @Test
    public void test(){
    	ListNode root=new ListNode(1);
    	ListNode node2=new ListNode(2);
    	ListNode node3=new ListNode(3);
    	ListNode node4=new ListNode(4);
    	ListNode node5=new ListNode(5);
    	root.next=node2;node2.next=node3;
    	node3.next=node4;node4.next=node5;
    	node5.next=node3;
    	Assert.assertEquals(3, detectCycle(root).val);
    	
    }
}
