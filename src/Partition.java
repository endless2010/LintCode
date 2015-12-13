import org.junit.Test;

/*
 * 给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。
 * 你应该保留两部分内链表节点原有的相对顺序。
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null)
        	return head;
        ListNode dumpSmaller=new ListNode(0);
        ListNode dumpSmallerLast=dumpSmaller;
        ListNode dumpLargerOrEquals=new ListNode(0);
        ListNode dumpLargerOrEqualsLast=dumpLargerOrEquals;
        while(head!=null){
        	ListNode next=head.next;
        	if(head.val<x){
        		dumpSmallerLast.next=head;
        		dumpSmallerLast=dumpSmallerLast.next;
        	}else {
        		dumpLargerOrEqualsLast.next=head;
        		dumpLargerOrEqualsLast=dumpLargerOrEqualsLast.next;
        	}
        	head=next;
        }
        dumpSmallerLast.next=dumpLargerOrEquals.next;
        dumpLargerOrEqualsLast.next=null;
        return dumpSmaller.next;
    }
    @Test
    public void test(){
    	System.out.println(partition(ListNode.fromArray(new int[]{1,4,3,2,5,2}),0));
    	System.out.println(partition(ListNode.fromArray(new int[]{1,4,3,2,5,2}),1));
    	System.out.println(partition(ListNode.fromArray(new int[]{1,4,3,2,5,2}),2));
    	System.out.println(partition(ListNode.fromArray(new int[]{1,4,3,2,5,2}),3));
    	System.out.println(partition(ListNode.fromArray(new int[]{1,4,3,2,5,2}),4));
    	System.out.println(partition(ListNode.fromArray(new int[]{1,4,3,2,5,2}),5));
    }
}
