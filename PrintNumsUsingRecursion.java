package Study;

public class PrintNumsUsingRecursion {

	public static void main(String[] args) {
		printx(7);
		System.out.println(factorial(7));
	}
	
	public static void printx(int n)
	{
	    if(n == 1)
	    {
	        System.out.println(n);
	        return;
	    }
	        
	    printx(n-1);
	    System.out.println(n);
	}
	
	public static int factorial(int n)
	{
	    if (n == 0)
		return 1;
	    return n * factorial(n - 1);
	}

}
