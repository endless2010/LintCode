import junit.framework.Assert;

import org.junit.Test;

/*
 * 给出1-3->2->null，给它排序变成1->2->3->null
 */
public class SortList {
    	public ListNode sortList(ListNode head){
			if(head==null)
				return head;
			ListNode newRoot=head;
			head=head.next;
			newRoot.next=null;
			while(head!=null){
				ListNode temp=newRoot;
				ListNode prev=null;
				while(temp!=null&&temp.val<head.val){
					prev=temp;
					temp=temp.next;
				}
				ListNode insertNode=head;
				head=head.next;
				if(prev!=null)
					prev.next=insertNode;
				else
					newRoot=insertNode;
				insertNode.next=temp;
			}
			return newRoot;
		}
    	@Test
    	public void test(){
    		ListNode node=sortList(ListNode.fromArray(new int[]{1,3,2}));
    		Assert.assertEquals(1,node.val);
    		Assert.assertEquals(2,node.next.val);
    		Assert.assertEquals(3,node.next.next.val);
    		Assert.assertNull(node.next.next.next);
    	}
    
}
