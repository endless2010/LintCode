import java.util.Arrays;

import org.junit.Test;

/*
 * The hash function is:
 * int hashcode(int key, int capacity) {
 *     return key % capacity;
 * }
 * 
 * here we have three numbers, 9, 14 and 21, where 21 and 9 share the same position as they all have the same 
 * hashcode 1 (21 % 4 = 9 % 4 = 1). We store them in the hash table by linked list.
 * rehashing this hash table, double the capacity, you will get:
 * size=3, capacity=8
 * index:   0    1    2    3     4    5    6   7
 * hash : [null, 9, null, null, null, 21, 14, null]
 * Given the original hash table, return the new hash table after rehashing .
 * Given [null, 21->9->null, 14->null, null],
 * return [null, 9->null, null, null, null, 21->null, 14->null, null]
 */
public class Rehashing {
	public ListNode[] rehashing(ListNode[] hashTable) {
		if(hashTable==null || hashTable.length==0)
			return hashTable;
		int capacity = hashTable.length * 2;
		ListNode[] newTable=new ListNode[capacity];
		for(int i=0;i<hashTable.length;++i){
			ListNode node=hashTable[i];
			while(node!=null){
				int code=hashcode(node.val,capacity);
				ListNode next=node.next;
				node.next=null;
				if(newTable[code]!=null){
					ListNode temp=newTable[code];
					while(temp.next!=null)
						temp=temp.next;
					temp.next=node;
				}else{
					newTable[code]=node;
				}
				node=next;
			}
		}
		return newTable;

	}

	int hashcode(int key, int capacity) {
		if (key > 0)
			return key % capacity;
		else
			return (key % capacity + capacity) % capacity;
	}

	@Test
	public void test() {
		 ListNode[] nodes=new ListNode[4];
		 nodes[1]=new ListNode(21);nodes[1].next=new ListNode(9);
		 nodes[2]=new ListNode(14);
		 System.out.println(Arrays.toString(nodes));		 
		 ListNode[] newNodes=rehashing(nodes);
		 System.out.println(Arrays.toString(newNodes));
		 
	}
}
