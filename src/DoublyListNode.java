

public class DoublyListNode {
	int val;
	DoublyListNode next;
	DoublyListNode prev;
	public DoublyListNode(int val){
		this.val=val;
	}
	public String toString(){
		StringBuilder sb=new StringBuilder();
		DoublyListNode temp=this;
		while(temp!=null){
			sb.append("["+temp.val);
			sb.append(",prev="+(temp.prev!=null?temp.prev.val:"null"));
			sb.append(",next="+(temp.next!=null?temp.next.val:"null"));
			sb.append("]");
			temp=temp.next;
		}
		return sb.toString();
	}
}