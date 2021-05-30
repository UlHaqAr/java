package Study;

import java.util.Stack;

public class SortAndInsertionUsingRecursion {

	  private Stack<Integer> sortedStk;
	  private Stack<Integer> unsortedStk;

	  public static void main(String[] args)
      {
    	SortAndInsertionUsingRecursion obj = new SortAndInsertionUsingRecursion();
    	
    	//insert
    	obj.sortedStk = new Stack<Integer>();
    	obj.sortedStk.push(1);
    	obj.sortedStk.push(2);
    	obj.sortedStk.push(4);
    	obj.sortedStk.push(5);
    	obj.sortedStk.push(6);
    	obj.sortedStk.push(7);
    	
    	obj.sortedStk.forEach( i -> System.out.print(i+" "));
    	
    	insert(obj.sortedStk, 3);
        
    	System.out.println();
    	obj.sortedStk.forEach( i -> System.out.print(i+" "));
    	
    	System.out.println();
    	//sorting
    	obj.unsortedStk = new Stack<Integer>();
    	obj.unsortedStk.push(5);
    	obj.unsortedStk.push(1);
    	obj.unsortedStk.push(2);
    	obj.unsortedStk.push(0);
    	obj.unsortedStk.push(3);
    	
    	obj.unsortedStk.forEach( i -> System.out.print(i+" "));
    	
    	sort(obj.unsortedStk);
        
    	System.out.println();
    	obj.unsortedStk.forEach( i -> System.out.print(i+" "));
      }

	private static void insert(Stack<Integer> stk2, int i) 
	{
		//insert the number at end, if sorted list is empty
		//insert the number at end, if number >= last item in sorted list
		if(stk2.isEmpty() || stk2.get(stk2.size()-1) < i)
		{
			stk2.push(i);
			return;
		}

		//pop the last item from sorted array, and call insert again on remaining list. We are traversing from right direction 
		//in the sorted list to find the correct insertion point for our element.
		//If the element would have been greater than the last element (n-1 index) in the sorted list, it would have hit base condition.
		//but it didnt. which means insertion point lies between 0 to n-2. We can pop off this n-1(last index) item from list.
		int lastItem = stk2.pop();
		insert(stk2, i);
		
		//put the item back
		stk2.push(lastItem);
		return;
	}
	
	/**
	 *
	 unsortedList = 5 1 2 0 3
	 recursion step 1 : unsortedList = 5 1 2 0 , poppedItem = 3 
	 recursion step 2 : unsortedList = 5 1 2   , poppedItem = 0 
	 recursion step 3 : unsortedList = 5 1     , poppedItem = 2 
	 recursion step 4 : unsortedList = 5       , poppedItem = 1
	 base condition is hit. start inserting now
	 insert step 1 : unsortedList =  1 5 
	 insert step 2 : unsortedList =  1 2 5 
	 insert step 3 : unsortedList =  0 1 2 5 
	 insert step 4 : unsortedList =  0 1 2 3 5 
	*/
	private static void sort(Stack<Integer> stk2) 
	{
		//recursion hits base condition when only one element is left in the unsorted list
		if(stk2.size() == 1)
		{
			return;
		}

		//pop the last item from unsorted list, and call the sort function on remaining
		int lastItem = stk2.pop();
		sort(stk2);
		
		//insert the popped item to the sorted list obtained. The insert method takes care of inserting the element at proper position in a sorted list
		insert(stk2,lastItem);
		return;
	}
	
}
