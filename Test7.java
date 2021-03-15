package Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

// lambda
public class Test7 {

	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4};
		List<Integer> loi = Arrays.asList(arr);
		List<String> los = Arrays.asList("a","b");
		
		System.out.println("****1***");
		
		//usual routine
		for(Integer x: loi)
		{
			System.out.println(x);
		}
		
		System.out.println("****2***");
		
		//using for-each routine
		loi.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer x) {
				System.out.println(x);
			}
		});
		
		System.out.println("***3***");
		
		//using for-each routine with lambda
		loi.forEach((Integer x) -> System.out.println(x));
		
		System.out.println("***4***");
		
		//we know 'loi' is list of 'Integers'. let lambda infer the type
		loi.forEach((x) -> System.out.println(x));
		
		System.out.println("***5***");
		
		//only one argument, why do u need paranthesis
		loi.forEach(x -> System.out.println(x));
		
		System.out.println("***6***");
		
		//'forEach' is gonna give u values one by one. all i want is to pass that value to a function named 'println' (method reference)
		loi.forEach(System.out::println); //instance method
		loi.forEach(String::valueOf); //static method
		los.forEach(String::toString);//valueOf takes the element as argument. toString is called 'on' the element. Even though the syntax is same 'class:method', there's difference.
		
	}

}
