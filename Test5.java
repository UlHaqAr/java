package Test;

@SuppressWarnings("preview")
//only test5 and test4 can extend Shape
sealed class Shape permits Test5, Test4
{
	public static void printSide()
	{
		System.out.println("print side");
	}
}

public final class Test5 extends Shape{
//public non-sealed class Test5 extends Shape{
	
	/**
	 * selaed types - child classes have info about their superclass coz they extend it
	 *  with sealed types, a superclass can now tell what all can be its child classes
	 */
	public static void main(String[] args) 
	{
		printSide();
	}

}
