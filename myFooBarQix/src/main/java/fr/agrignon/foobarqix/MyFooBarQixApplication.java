package fr.agrignon.foobarqix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFooBarQixApplication {
	
	/**
	 * Default parameters
	 */
	private static final List<String> DEFAULT_PARAMETERS = new ArrayList<>(
		Arrays.asList(
			"1", "2", "3", "4", "5", "6", "7", "8", "9", 
			"10", "13", "15", "21", "33", "51", "53", 
			"101", "303", "105", "10101"
		)
	);
	
	/**
	 * Get list of numbers
	 * 
	 * @param args
	 * @return list
	 */
	private static List<String> getNumberList(String[] args) {		
		if (args.length > 1) 
		{	
			return Arrays.asList(args);
		} 
		else 
		{
			return DEFAULT_PARAMETERS;
		}
	}

	/**
	 * Entry point of the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FooBarQix fooBarQix = new FooBarQix();
		List<String> numbers = getNumberList(args);
		
		for (String number : numbers) {
			// Call compute method from FooBarQix
		    String result = fooBarQix.compute(number);
		    
		    System.out.format("%s => %s%n", number, result);	
		}
	}

}
