package Study;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SegmentTrees {

	private static final InputStream in = null;

	public static void main(String[] args) {
		
		int[] arr = {1, 3, 5, 7, 9, 11}; 
		int n = arr.length ; 

		// Build segment tree from given array 
		int[] segTree = constructST(arr, n); 
		
		System.out.print("Segmented Tree : ");
		for(int x:segTree)System.out.print(x+" ");

		// Print sum of values in array from index 1 to 3 
		System.out.println("");
		System.out.println("Sum of elements range 1-3(indexes): " +getSum(segTree, n, 1, 3));

		System.out.println("Update: arr[1] = 10 "); 
		// segment tree nodes 
		updateValue(arr, segTree, n, 1, 10); 

		System.out.print("Segmented Tree : ");
		for(int x:segTree)System.out.print(x+" ");
		
		// Print sum of values in array from index 1 to 3 
		System.out.println("");
		System.out.println("Sum of elements range 1-3(indexes): " +getSum(segTree, n, 1, 3));
		
	}

	static int[] constructST(int arr[], int n) 
	{ 
		//Height of segment tree 
		double d = (Math.log(n) / Math.log(2)); 
		int x = (int) Math.ceil(d);
		System.out.println("height: "+x);

		//Maximum size of segment tree 
		int max_size = (int) (2*Math.pow(2, x) - 1); 
		System.out.println("size of array: "+max_size);

		// Allocate memory 
		int[] segTree = new int[max_size]; 

		constructSTUtil(arr, 0, n-1, segTree, 0); 

		// Return the constructed segment tree 
		return segTree; 
	} 
	
	//segmented tree : each node stores the sum of its child nodes (in IM perspective, each item in the segmented array holds the sum of some segment of input array)
	static int constructSTUtil(int arr[], int start, int end, int[] segTree, int curr) 
	{ 
		// If there is one element in array, store it in current node of 
		// segment tree and return 
		if (start == end) 
		{ 
			segTree[curr] = arr[start]; 
			return arr[start]; 
		} 

		int mid = start+ ((end-start)/2); 
		segTree[curr] = constructSTUtil(arr, start, mid, segTree, curr*2+1) + 
				constructSTUtil(arr, mid+1, end, segTree, curr*2+2); 
		return segTree[curr]; 
	} 
	
	static int getSum(int[] segTree, int n, int rangeStart, int rangeEnd) 
	{ 
		// Check for erroneous input values 
		if (rangeStart < 0 || rangeEnd > n-1 || rangeStart > rangeEnd) 
		{ 
			return -1; 
		} 

		return getSumUtil(segTree, 0, n-1, rangeStart, rangeEnd, 0); 
	} 
	
	//Each item in the segmented tree holds the sum for a range of indexes. But we do not maintain a data structure holding that information. Just the value in the array
	//so we pass the initial value 0,n-1,0 to the arguments currStart,currEnd,currIndex. So that we have a starting point
	//the segmented tree is constructed using a heap data structure. so we can use the formulae for accessing child and parent to a value in the array
	static int getSumUtil(int[] segTree, int currStart, int currEnd, int rangeStart, int rangeEnd, int currIndex) 
	{ 
		//curr node range is equal to asked range OR curr node range falls inside asked range
		//ex: asked range is 2-6 and curr node has sum value for indexes 3 to 5, so we return the value of this node of segmented array 
		if (rangeStart <= currStart && rangeEnd >= currEnd) 
			return segTree[currIndex]; 

		// If segment of this node is outside the given range 
		//ex: asked range is 2-6 and curr node has sum value for indexes 7 to 9 
		if (currEnd < rangeStart || currStart > rangeEnd) 
			return 0; 

		// If a part of this segment overlaps with the given range 
		int mid = currStart+ (currEnd-currStart)/2; 
		return getSumUtil(segTree, currStart, mid, rangeStart, rangeEnd, 2*currIndex+1) + 
			getSumUtil(segTree, mid+1, currEnd, rangeStart, rangeEnd, 2*currIndex+2); 
		
		//case 1: curr range is inside the asked range - return value
		//case 2: curr range is outside the asked range - return 0
		//case 3: split at mid , update the curr range
	} 
	
	//we start updating with curr=0 (that is root of segment tree)
	//then proceed to left and right subtree
	//we are not adding the actual value whcih user gave , but the difference
	static void updateValueUtil(int[] segTree, int currStart, int currEnd, int index, int diff, int curr) 
	{ 
		//If the input index lies outside the range of this segment 
		if (index < currStart || index > currEnd) 
			return; 

		segTree[curr] = segTree[curr] + diff; 
		if (currEnd != currStart) 
		{ 
			int mid = currStart+ (currEnd-currStart)/2; 
			updateValueUtil(segTree, currStart, mid, index, diff, 2*curr + 1); 
			updateValueUtil(segTree, mid+1, currEnd, index, diff, 2*curr + 2); 
		} 
	} 

	static void updateValue(int arr[], int[] segTree, int n, int i, int value) 
	{ 
		// Check for erroneous input index 
		if (i < 0 || i > n-1) 
		{ 
			return; 
		} 

		// Get the difference between new value and old value 
		int diff = value - arr[i]; 

		// Update the value in input array 
		arr[i] = value; 

		// Update the values of nodes in segment tree 
		updateValueUtil(segTree, 0, n-1, i, diff, 0); 
	} 
	
	
	
}