package Test;

import java.util.Arrays;
import java.util.List;

public class Test8 {

	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5,6};
		List<Integer> loi = Arrays.asList(arr);
		printElementsUsingFor(loi);
		printElementsUsingStream(loi);
	}

	private static void printElementsUsingStream(List<Integer> loi) 
	{
		int sum = 0;
		for(int i=0;i<loi.size();i++)
		{
			if(loi.get(i) % 2 ==0)
			{
				int temp = loi.get(i) * 2;
				sum += temp;
			}
		}
		System.out.println();
		System.out.println("sum :"+sum);
	}

	private static void printElementsUsingFor(List<Integer> loi) 
	{
		//reduce
		int sum1 = loi.stream()
					 .reduce(0,(total,x) -> {
												if(x % 2 == 0)
												{
													int temp = x * 2;
													total += temp;
												}
												return total;
											});
		
		System.out.println("sum1 :"+sum1);
		
		//filter
		int sum2 = loi.stream()
					  .filter(x -> x % 2 == 0)
					  .reduce(0,(total,x) -> {
													int temp = x * 2;
													total += temp;
													return total;
											 });
		
		System.out.println("sum2 :"+sum2);
		
		//map
		int sum3 = loi.stream()
					  .filter(x -> x % 2 == 0)
					  .map(x -> x*2)
					  .reduce(0,(total,x) -> {
													total += x;
													return total;
											 });
		
		System.out.println("sum3 :"+sum3);
		
		//accumulators, if no return statement is present, return the calculated values of the logic written. so we can remove the 'return total' statement
		int sum4 = loi.stream()
					  .filter(x -> x % 2 == 0)
					  .map(x -> x*2)
					  .reduce(0,  (total,x) -> total+x );
		
		System.out.println("sum4 :"+sum4);
		
		// Use the sum() method in Integer class
		int sum5 = loi.stream()
				  .filter(x -> x % 2 == 0)
				  .map(x -> x*2)
				  .reduce(0,  (total,x) -> Integer.sum(total, x) );
	
		System.out.println("sum5 :"+sum5);
		
		// Use the sum() method in Integer class, as method reference, coz same arguments are passed
		int sum6 = loi.stream()
				  .filter(x -> x % 2 == 0)
				  .map(x -> x*2)
				  .reduce(0,  Integer::sum );
	
		System.out.println("sum6 :"+sum6);
	}

}
