
import org.junit.Assert;
import org.junit.Test;

/*
 * 给出链表1->2->3->4->5->null， m = 2 和n = 4，返回1->4->3->2->5->null
 * m，n满足1 ≤ m ≤ n ≤ 链表长度
 */
public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if(head==null || n==m)
        	return head;
        ListNode from=head;
        ListNode prev=null;
        ListNode to=head;
        for(int i=1;i<m;++i){
        	prev=from;
        	from=from.next;
        	to=to.next;
        }
        for(int i=1;i<n-m;++i)
        	to=to.next;
        ListNode node=reverse(from,to);
        System.out.println(node);
        if(prev!=null)
        	prev.next=node;
        else
        	prev=node;
        node.next=to;
        return head;
    }
    public ListNode reverse(ListNode from,ListNode to) {
    	if(from==null || to==null || from==to)
    		return from;
    	ListNode next=reverse(from.next,to);
    	next.next=from;
    	from.next=null;
    	return to;
    }
    @Test
    public void test(){
    	ListNode node=reverseBetween(ListNode.fromArray(new int[]{1,2,3,4,5}),2,4);
    	Assert.assertArrayEquals(new int[]{1,4,3,2,5},node.toArray());
    }
}
