package Test;

//switch 
public final class Test4 extends Shape{

	public static void main(String[] args) 
	{
		printDay(2);
		printDay2(5);
	}

	public static void printDay(int num)
	{
		String txt="";
		switch(num)
		{
		case 0 :
			txt = "MON. Eat chicken";
			break;
		case 1 :
			txt = "TUE. Eat mutton";
			break;
		case 2 :
			txt = "WED. Eat fish";
			break;
		default :
			txt = "Every day is shawarma day bro.";
			break;
		}
		System.out.println(txt);
	}
	
	//use switch as an expression which returns values. No 'break' statements.
	public static void printDay2(int num)
	{
		String txt= switch(num)
					{
						case 0 -> "MON. Eat chicken";
						case 1 -> "TUE. Eat mutton";
						case 2 -> "WED. Eat fish";
						default -> "Every day is shawarma day bro.";
					};
		System.out.println(txt);
	}
}
