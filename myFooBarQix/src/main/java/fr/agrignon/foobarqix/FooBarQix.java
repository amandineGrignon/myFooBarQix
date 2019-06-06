package fr.agrignon.foobarqix;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

public class FooBarQix {
	
	/**
	 * The result 
	 */
	private StringBuilder resolved = new StringBuilder();
	
	/**
	 * The input
	 */
	private String input;
	
	/**
	 * The FooBarQix rules
	 */
	private static final Map<Integer, String> FOOBARQIX_RULES;
	static {
        // Using a LinkedHashMap to keep the insertion order
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(3, "Foo");
        map.put(5, "Bar");
        map.put(7, "Qix");

        // Unmodifiable object makes it thread-safe (only reads can occurs)
        FOOBARQIX_RULES = Collections.unmodifiableMap(map);
    }
	
	/***
	 * To convert the source to integer
	 * 
	 * @param source
	 * @return number
	 */
	private Integer checkNumber() {
		Integer number = Integer.valueOf(input);
		
		if (number < 0) {
			throw new IllegalArgumentException(MessageFormat.format("{0} is out of bounds", input));
		}
		
		return number;
	}
	
	/***
	 * "is divisible by" rules
	 * 
	 * @param number
	 */
	private void divisibleRules(Integer number) {
		for (Map.Entry<Integer, String> entry : FOOBARQIX_RULES.entrySet()) {
			if ((number % entry.getKey()) == 0)
				resolved.append(entry.getValue());
		}
	}
	
	/***
	 * Check content of the source string
	 * 
	 * @param source
	 */
	private void checkContentString() {
		for (char c : input.toCharArray()) {
			for (Map.Entry<Integer, String> entry : FOOBARQIX_RULES.entrySet()) {
				if (c == String.valueOf(entry.getKey()).charAt(0))
				{
					resolved.append(entry.getValue());
				}
			}
			
			if (c == '0') {
				resolved.append('*');
			}
		}
	}
	
	/**
	 * Write the source number if the result is empty
	 * 
	 * @param source
	 */
	private void checkIfEmptyString() {
		if (StringUtils.isEmpty(resolved.toString()) 
				|| (StringUtils.isEmpty(resolved.toString().replace("*", ""))))
		{
			resolved = new StringBuilder();
			for (char c : input.toCharArray()) {
				if (c == '0')
					resolved.append('*');
				else
					resolved.append(c);
			}
		}
	}
	
	/***
	 * Implements the following rules :
	 * 
	 * If the number is divisible by 3, write “Foo” instead of the number
	 * If the number is divisible by 5, add “Bar”
	 * If the number is divisible by 7, add “Qix”
	 * For each digit 3, 5, 7, add “Foo”, “Bar”, “Qix” in the digits order.
	 * And keep a trace of 0 in numbers, each 0 must be replace par char “*“
	 * 
	 * @param source
	 * @return result
	 */
	public String compute(String input) {		
	
		// Save the input
		this.input = input;
		
		// Check number
        Integer number = checkNumber();
        
        // Divisible rules
        divisibleRules(number);
	
		// Check content of the source string
		checkContentString();
		
		// Write the source number if the result is empty
		checkIfEmptyString();
		
		return resolved.toString();
	}
}
