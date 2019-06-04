package fr.agrignon.foobarqix;

public class FooBarQix {


	public static String compute(String source) {
		
		// to build the string
        StringBuilder sb = new StringBuilder();
		
		int number = Integer.parseInt(source);
		
		if (number % 3 == 0)
			sb.append("Foo");
		else if (number % 5 == 0)
			sb.append("Bar");
		
		return sb.toString();
	}
	
}
