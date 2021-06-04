package Study;

import java.util.Stack;

public class ReverseStackUsingRecursion {

	  private Stack<Integer> sampleStack;

	  public static void main(String[] args)
      {
    	ReverseStackUsingRecursion obj = new ReverseStackUsingRecursion();
    	//reverse
    	obj.sampleStack = new Stack<Integer>();
    	obj.sampleStack.push(11);
    	obj.sampleStack.push(2);
    	obj.sampleStack.push(15);
    	obj.sampleStack.push(5);
    	obj.sampleStack.push(6);
    	obj.sampleStack.push(7);
    	
    	obj.sampleStack.forEach( i -> System.out.print(i+" "));
    	
    	reverse(obj.sampleStack);
        
    	System.out.println();
    	obj.sampleStack.forEach( i -> System.out.print(i+" "));
    	
      }

	private static void reverse(Stack<Integer> sortedStk2) 
	{
		if(sortedStk2.size() == 1)
		{
			return;
		}
		int lastItem = sortedStk2.pop();
		reverse(sortedStk2);
		insertAtBottom(sortedStk2, lastItem);
		return;
	}

	/**
	 * stack = 1 2 4 5 6 
	 * insert 7 for stck to become = 7 1 2 4 5 6
	 * pop 6 -> pop 5 -> pop 4 -> pop 2 -> pop 1 -> push 7
	 * push_back 1
	 * push_back 2
	 * push_back 4
	 * push_back 5
	 * push_back 6
	 */
	private static void insertAtBottom(Stack<Integer> stack2, int item) 
	{
		if(stack2.isEmpty())
		{
			stack2.push(item);
			return;
		}
		int lastItem = stack2.pop();
		insertAtBottom(stack2, item);
		stack2.push(lastItem);
		return;		
	}

}
