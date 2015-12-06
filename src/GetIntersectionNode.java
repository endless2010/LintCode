import org.junit.Assert;
import org.junit.Test;

/*
 * 请写一个程序，找到两个单链表最开始的交叉节点。
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA=0;
        int lengthB=0;
        ListNode temp=headA;
        while(temp!=null){
        	lengthA++;
        	temp=temp.next;
        }
        temp=headB;
        while(temp!=null){
        	lengthB++;
        	temp=temp.next;
        }
        while(lengthA>lengthB){
        	headA=headA.next;
        	lengthA--;
        }
        while(lengthA<lengthB){
        	headB=headB.next;
        	lengthB--;
        }
        while(headA!=null){
        	if(headA==headB)
        		return headA;
        	headA=headA.next;
        	headB=headB.next;
        }
        return null;
    
    }  
    @Test
    public void test(){
    	ListNode head1=new ListNode(1);
    	ListNode node2=new ListNode(2);ListNode node3=new ListNode(3);
    	ListNode head2=new ListNode(10);
    	head1.next=node2;node2.next=node3;
    	head2.next=node3;
    	Assert.assertEquals(node3,getIntersectionNode(head1,head2));
    }
}
