package Test;

public class Test1 {

public static void main(String[] args) 
	{
		printText("rty");
		printText((Integer)5);
	}

	
	@SuppressWarnings("preview")
	static void printText(Object o) 
	{
		if(o instanceof String)
		{
			String s = (String) o;
			System.out.println(s.charAt(1));
		}
		
		if(o instanceof String s)
		{
			System.out.println(s.charAt(1));
		}
		
		if(o instanceof Integer in)
		{
			System.out.println(in.doubleValue());
		}
    }

}
