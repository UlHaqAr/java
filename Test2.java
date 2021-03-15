package Test;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

	//var mem = 15; //cannot have 'var' class variables. Its only local.
	
	public static void main(String[] args) 
	{
		//eliminates the need to give type declaration. It infers from the value 
		ArrayList<String> arr1 = new ArrayList<String>();
		List<String> arr2 = new ArrayList<>();
		var arr3 = new ArrayList<String>();
		
		System.out.println(arr1.getClass().getTypeName());
		System.out.println(arr2.getClass().getTypeName());
		System.out.println(arr3.getClass().getTypeName());

		//java is still type-safe. Once the 'var' keyword takes a type from value(RHS), u cannot change it.
		var i = 10;
		//i = "fh"; // invalid
	}
	
	//cannot use vars in method arguments. coz it cannot infer the type. It must have a RHS
//	public int add(var x, var y)
//	{
//		var z = x+ y ;
//		return z;
//	}
	
	public <K extends Number> double add(K x, K y)
	{
		double z = x.doubleValue() + y.doubleValue();
		return z;
	}

}
