package Study;

public class PrintSubsetsUsingRecursion {

	  public static void main(String[] args)
      {
    	String ip = "abcd";
    	String op = "";
    	
    	solve(ip, op);
      }

   /**
    * left subtree indicates if we dont take the character, right one vice-versa
    * all the possible choices (all leaf nodes) is the answer.
    * 
    * Coz we make choices for a character with all previous leaf nodes, we get "all" combinations.
    * example, at level 2, we make choices for b wrt a and _ .
    * and, again at level 3, we make choices for c wrt a. so we get both ac and ab. 
    * 
    * 									abc							 ip=abc
    * 							    /         \
    * 							  _              a                   ip=bc
    *                          /    \          /    \
    * 					   _         b        a       ab             ip=c
    *                    /   \     /   \     /  \     /   \
    *                  _     c    b    bc    a   ac   ab    abc      ip=_
    * 
    * 
    */
	private static void solve(String ip, String op) 
	{
		if(ip.length()==0)
		{
			System.err.println(op);
			return;
		}
		
		// op1 will not have the character
		String op1 = op;
		//op2 will have the character
		String op2 = op;
		op2 = op2+ip.charAt(0);
		//remove the character from input. its work is done
		ip = ip.substring(1);
		
		solve(ip,op1);
		solve(ip,op2);
		
		return;
	}

}
