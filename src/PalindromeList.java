import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeList {
	
    public boolean isPalindrome(ListNode head) {
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	while(head!=null){
    		list.add(head.val);
    		head=head.next;
    	}
    	int start=0,end=list.size()-1;
    	while(start<end){
    		if(!list.get(start).equals(list.get(end)))
    			return false;
    		start++;
    		end--;
    	}
    	return true;
    }
    @Test
    public void test(){
    	Assert.assertEquals(false,isPalindrome(ListNode.fromArray(new int[]{2,3,4,5,6})));
    	Assert.assertEquals(true,isPalindrome(ListNode.fromArray(new int[]{1})));
    	Assert.assertEquals(true,isPalindrome(ListNode.fromArray(new int[]{1,2,2,1})));
    	Assert.assertEquals(true,isPalindrome(ListNode.fromArray(new int[]{1,-2,-2,1})));
    	Assert.assertEquals(false,isPalindrome(ListNode.fromArray(new int[]{1,2,-2,1})));
    	Assert.assertEquals(true,isPalindrome(ListNode.fromArray(new int[]{1,2,3,2,1})));
    	Assert.assertEquals(true,isPalindrome(ListNode.fromArray(new int[]{1,23,23,1})));
    	Assert.assertEquals(true,isPalindrome(ListNode.fromArray(new int[]{1,128,128,1})));
    }
    
}
