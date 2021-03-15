package Test;

public class Test6 {

	/**
	 * go to C:\Users\UlHaqAr\eclipse-workspace\jdk14workspace\Study\bin\Test and check the number of inner classes being created
	 * @param arg
	 */
	public static void main(String arg[])
	{
//		callAnonymousFncThread();
		callLambdaThread();
		System.out.println("in main");
	}

//	private static void callAnonymousFncThread() {
//		Thread th;
//		th = new Thread(new Runnable() 
//		{
//			@Override
//			public void run() {
//				System.out.println("in thread anonymous");
//			}
//		});
//		th = new Thread(new Runnable() 
//		{
//			@Override
//			public void run() {
//				System.out.println("in thread anonymous");
//			}
//		});
//		th = new Thread(new Runnable() 
//		{
//			@Override
//			public void run() {
//				System.out.println("in thread anonymous");
//			}
//		});
//		th.start();
//	}

	/**
	 * the anonymous class 'Runnable' has only one method. So we dont care about the name of the method 'run'
	 */
	private static void callLambdaThread() {
		Thread th;
		th = new Thread(() -> System.out.println("in thread lambda"));
		th = new Thread(() -> System.out.println("in thread lambda"));
		th = new Thread(() -> System.out.println("in thread lambda"));
		th.start();
	}

}
