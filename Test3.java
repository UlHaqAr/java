package Test;

public class Test3 {

	//text block
	//eliminates the need to give escape sequences for new lines OR quotes in a string. 
	public static void main(String[] args) {
		
		String s1 = "Hi, \n" + "\n Welcome to \"new\" features" + " in Java 15. \n" + "\nRegards, \nArsal";
		System.out.println(s1);
		
		System.out.println();
		
		String s2 = """
				Hi,
				
				 Welcome to "new" features in Java 15.
					
				Regards,
				Arsal
				""";
		System.out.println(s2);

	}

}
