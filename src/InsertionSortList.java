import org.junit.Assert;
import org.junit.Test;


public class InsertionSortList {
		public ListNode insertionSortList(ListNode head){
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
			ListNode node1=ListNode.fromArray(new int[]{3,5,1,2,4});
			Assert.assertArrayEquals(new int[]{1,2,3,4,5},insertionSortList(node1).toArray());
			
			ListNode node2=ListNode.fromArray(new int[]{1,2,3});
			Assert.assertArrayEquals(new int[]{1,2,3},insertionSortList(node2).toArray());
			
			ListNode node3=ListNode.fromArray(new int[]{5,4,3,2,1});
			Assert.assertArrayEquals(new int[]{1,2,3,4,5},insertionSortList(node3).toArray());
			
			ListNode node4=ListNode.fromArray(new int[]{1});
			Assert.assertArrayEquals(new int[]{1},insertionSortList(node4).toArray());
		}
}
