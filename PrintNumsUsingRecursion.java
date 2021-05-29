package Study;

public class PrintNumsUsingRecursion {

	public static void main(String[] args) {
		printx(7);
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

}
