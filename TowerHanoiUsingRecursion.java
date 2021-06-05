package Study;

public class TowerHanoiUsingRecursion {

	//	you really have to work out recursion on paper with at least n=5, 
	//	to understand why this works with just three poles. 
	  public static void main(String[] args)
      {
    	int s=1;//source pole
    	int h=2;//helper pole
    	int d=3;//destination pole
    	int n=3;//num of disk at source
    	
    	solve(s,d,h,n);
      }

	/**
	 * say 3 disk. d1, d2, d3, d4 (all at source p1 initially). d1 on top.
	 * three poles p1 p2 p3
	 * 
	 * keep d4 at p1 itself. 
	 * Move d1,d2,d3 to p2. -XX
	 * now move d4 to p3(destination pole)
	 * keep d3 at p2 itself. 
	 * Move d1,d2 to p1. -XX
	 * now move d3 to p3(destination pole)
	 * keep d2 at p1 itself. 
	 * Move d1 to p2. -XX
	 * now move d2 to p3(destination pole)
	 * move d1 to p3(destination pole)
	 * 
	 * To understand this movements marked as -XX, u need to work it out on paper. 
	 */
	private static void solve(int s, int d, int h, int n) 
	{
		if(n==1)
		{
			System.out.println("Moving disk "+n+" from "+s+" to "+d);
			return;
		}
		//move (1 to n-1th) disks from source to helper. Now source will have only one disk left. Move that to destination.
		solve(s,h,d,n-1); //X1
		System.out.println("Moving disk "+n+" from "+s+" to "+d); //X2
		//consider the helper pole as source pole, and source pole as helper. coz all disks are at helper at this moment. Repeat.
		solve(h,d,s,n-1); 
	}
	
	/**
	 *  |1| | | | |             
	 *  |2| | | | |
	 *  |3| | | | |
	 *  |_| |_| |_|
	 *  
	 *  | | | | | |
	 *  |2| | | | |
	 *  |3| | | |1|
	 *  |_| |_| |_|
	 *  
	 *  | | | | | |
	 *  | | | | | |
	 *  |3| |2| |1|
	 *  |_| |_| |_|
	 *  
	 *  | | | | | |
	 *  | | |1| | |
	 *  |3| |2| | |  X1
	 *  |_| |_| |_|
	 *  
	 *  | | | | | |
	 *  | | |1| | |
	 *  | | |2| |3|  X2
	 *  |_| |_| |_|
	 *  
	 *  | | | | | |
	 *  | | | | | |
	 *  |1| |2| |3|
	 *  |_| |_| |_|
	 *  
	 *  | | | | | |
	 *  | | | | |2|
	 *  |1| | | |3|
	 *  |_| |_| |_|
	 *  
	 *  | | | | |1|
	 *  | | | | |2|
	 *  | | | | |3|
	 *  |_| |_| |_|
	 *  
	 */

	

}
