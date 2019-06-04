package fr.agrignon.foobarqix;

public class FooBarQix {


	public static String compute(String source) {
		
		int number = Integer.parseInt(source);
		
		if (number % 3 == 0)
			return "Foo";
		
		return null;
	}
	
}
