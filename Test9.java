package Test;

@FunctionalInterface
interface MyInterface 
{
	public int addTwenty(int x);
//	public int addThirty(int x); //the annotation makes sure there's only one method in the interface
}

public class Test9 {

	public static void main(String[] args) 
	{
		MyInterface myint = new MyInterface() {
			
			@Override
			public int addTwenty(int x) {
				return x+20;
			}
		};
		
		//passing the interface implementation
		executeMyInterface(myint);
		//using lambda, since we have only one method in the interface
		executeMyInterface((x) -> x + 50);
	}

	private static void executeMyInterface(MyInterface myint) 
	{
		System.out.println(myint.addTwenty(5));
	}

}
