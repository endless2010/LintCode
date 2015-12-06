import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;


public class ImplementStackUsingQueue {

	class Queue {
		
	    public Queue() {}
	    
		private Stack<Integer> stack1=new Stack<Integer>();
		private Stack<Integer> stack2=new Stack<Integer>();
		
	    public void push(int element) {
	        stack1.push(element);
	    }
	    
	    public int pop() {
	    	if(stack2.isEmpty())
	        while(!stack1.isEmpty())
	        	stack2.push(stack1.pop());
	         return stack2.pop();
	    }
	    
	    public int top() {
	    	if(stack2.isEmpty())
		        while(!stack1.isEmpty())
		        	stack2.push(stack1.pop());
	    	return stack2.peek();
	    }
	    public boolean empty() {
	        return stack1.isEmpty()&& stack2.isEmpty();
	    }
	}
	@Test
	public void test(){
		Queue queue=new Queue();
		queue.push(2);
		queue.push(3);
		queue.push(4);
		Assert.assertEquals(false,queue.empty());
		Assert.assertEquals(2,queue.top());
		queue.pop();
		Assert.assertEquals(false,queue.empty());
		Assert.assertEquals(3,queue.top());
		queue.pop();
		Assert.assertEquals(false,queue.empty());
		Assert.assertEquals(4,queue.top());
		queue.pop();
		Assert.assertEquals(true,queue.empty());
	}
	}

