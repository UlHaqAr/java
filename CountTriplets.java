package Study;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CountTriplets {

	private static final InputStream in = null;

	public static void main(String[] args) {
		
		List<Long> arr = new ArrayList<Long> (); 
		arr.add((long) 1);
		arr.add((long) 3);
		arr.add((long) 9);
		arr.add((long) 9);
		arr.add((long) 27);
		arr.add((long) 81);
		long r =3;
		
		
//		List<Long> arr = new ArrayList<Long> (); 
//		arr.add((long) 1);
//		arr.add((long) 5);
//		arr.add((long) 5);
//		arr.add((long) 25);
//		arr.add((long) 125);
//		long r =5;
		
//		Long[] arr1 = new Long[100];
//        Arrays.fill(arr1, (long)1);
//        List<Long> arr = new ArrayList(Arrays.asList(arr1));
//        long r =1;
//        
		System.out.println(countTriplets(arr, r));
	}

	static long countTriplets(List<Long> arr, long r) {
		Map<Long,Long> leftmap = new HashMap<>();
		Map<Long,Long> rightmap = new HashMap<>();
		
		//put all items to right map initially
		for(long item:arr)
		{
			rightmap.put(item, rightmap.getOrDefault(item, 0L)+1);
		}
		long sum =0;
		for(int i=0;i<arr.size();i++)
		{
			long t = arr.get(i);
			//if item isnt divisible by r , then just move it from rightmap to leftmap
			//ex: 1,3,9,9,27,81 --> here 1 will not be divisible by r=3
			if(t % r != 0) 
			{
				leftmap.put(t, leftmap.getOrDefault(t, 0L)+1);
				rightmap.put(t, rightmap.getOrDefault(t, 0L)-1);
				continue;
			}
			long tbyr = t/r;
			long tintor = t*r;
			long less =0;
			long high =0;
			//decrement the count from right map
			rightmap.put(t, rightmap.getOrDefault(t, 0L)-1);
			
			//take the counts from left and right map
			less = leftmap.containsKey(tbyr) ? leftmap.get(tbyr):0;
			high = rightmap.containsKey(tintor) ? rightmap.get(tintor):0;
			
			sum += less*high;
			
			//put item in left map
			leftmap.put(t, leftmap.getOrDefault(t, 0L)+1);
		}
		return sum;
	}

	
	
	
}