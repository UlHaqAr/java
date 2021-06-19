package Study;

import java.util.ArrayList;
import java.util.List;

public class GenerateBalancedParenthesisUsingRecursion {

	  public static void main(String[] args)
      {
    	solve(3);
      }

	/**
	 * n=3
	 * we hv 3 pairs of brackets with us. (, (, (, ), ), )
	 * all possible combinations = ()()() , ()(()) , (())() , ((())) , (()())
	 * 														o=3, c=3
	 * 													/           	\
	 * 											(  o=2,c=3  	          cant take close at start
	 * 									   /    	    	 \___________
	 *                  (( o=1,c=3       		    	     \
	 *                   /     \         						  () o=2,c=2
	 *         ((( o=0,c=3     (() o=1,c=2    		    		  /      			\
	 *        |              /        \                 	()( o=1,c=2           if we take closed parenthesis, its gonna become unbalanced  
	 *      ((()    (()( o=0,c=2   (()) o=1,c=1             /          \
	 *         |         |          /          \ 			   ()(( o=0,c=2    ()() o=1,c=1		 
	 *      ((())     (()()   (())( o=0,c=1   unbalanced			|	              /        \
	 *         |         |	  	|                            ()(()      ()()( o=0,c=1   unbalanced
	 *      ((()))   (()())    (())()                           |             |
	 *                                                        ()(())       ()()()
	 *conclusions:
	 *	- start with open only. when o=c=n
	 *	- if either o becomes 0, or c becomes 0, after that, there are only one choice
	 *	- cannot take close parenthesis when o=c, i.e. previous result is balanced./ alternatively, u get closing choice only when c>o
	 *	- leaf node when o=c=0
	 * @param ip
	 * @param op
	 */
	private static void solve(int n) 
	{
		List<String> los = new ArrayList<>();
		int open = n;
		int close = n;
		String output = "";
		solve(open,close,output,los);
		for(String s : los)
		{
			System.out.println(s);
		}
	}

	private static void solve(int open, int close, String output, List<String> los) 
	{
		if(open == 0 && close == 0)
		{
			los.add(output);
			return;
		}
		//choice to put open parenthesis is present until o=0
		if(open != 0)
		{
			String op1 = output;
			op1 += "(";
			solve(open-1, close, op1, los);
		}
		//choice to put close parenthesis is present when c>o
		if(close > open)
		{
			String op2 = output;
			op2 += ")";
			solve(open, close-1, op2, los);
		}
		return;
	}

}
