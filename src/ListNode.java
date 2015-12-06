import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListNode {
	int val;
	ListNode next;
	public ListNode(int val,ListNode next){
		this.val=val;
		this.next=next;
	}
	public ListNode(int val){
		this.val=val;
	}

	@Override
	public String toString(){
		return Arrays.toString(toArray());
	}
	public static ListNode fromArray(int[] array){
		if(array==null||array.length==0)
			return null;
		ListNode head=new ListNode(array[0]);
		ListNode node=head;
		for(int i=1;i<array.length;++i){
			node.next=new ListNode(array[i]);
			node=node.next;
		}
		return head;
	}
	public int[] toArray() {
		ListNode temp=this;
		List<Integer> list=new LinkedList<Integer>();
		while(temp!=null){
			list.add(temp.val);
			temp=temp.next;
		}
		int[] result=new int[list.size()];
		for(int i=0;i<list.size();++i)
			result[i]=list.get(i);
		return result;
	}
}