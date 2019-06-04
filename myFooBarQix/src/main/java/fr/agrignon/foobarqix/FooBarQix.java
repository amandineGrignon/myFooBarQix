package fr.agrignon.foobarqix;

public class FooBarQix {

	public String compute(String number) {
		
		int nb = Integer.parseInt(number);
		
		if (nb % 3 == 0)
			return "Foo";
		
		return null;
	}
	
}
