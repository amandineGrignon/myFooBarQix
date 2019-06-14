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
	 * To convert the input to integer
	 * 
	 * @param input
	 * @return number
	 */
	private Integer convertInputToNumber(String input) {
		Integer number = Integer.valueOf(input);
		
		if (number < 0) 
		{
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
			// Add the value of the rule if the number is divisible by the key
			if ((number % entry.getKey()) == 0)
			{
				resolved.append(entry.getValue());
			}
		}
	}
	
	/***
	 * Rules on a character
	 * 
	 * @param c
	 */
	private void characterRules(char c) {
		for (Map.Entry<Integer, String> entry : FOOBARQIX_RULES.entrySet()) {
			// Add the value of the rule if the character is equals to the key
			if (c == String.valueOf(entry.getKey()).charAt(0))
			{
				resolved.append(entry.getValue());
			}
		}
		
		// Add '*' if the character is a zero
		if (c == '0')
		{
			resolved.append('*');
		}
	}
	
	/**
	 * Rules on an empty resolved
	 * 
	 * @param input
	 */
	private void emptyResolvedRules(String input) {
		resolved = new StringBuilder();
		
		// Scan all the characters of the input
		for (char c : input.toCharArray()) {
			if (c == '0') 
			{
				resolved.append('*');
			}
			else 
			{
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
	 * @param input
	 * @return result
	 */
	public String compute(String input) {		
	
		// Initialize
		this.resolved = new StringBuilder();
		
		// Convert to number (with check)
        Integer number = convertInputToNumber(input);
        
        // Divisible rules
        divisibleRules(number);

        // Scan all characters of the input
        for (char c : input.toCharArray()) {
        	// Rules on a character
        	characterRules(c);
        }

        // Check if the resolved is empty or contains only stars (*)
        if (StringUtils.isEmpty(resolved.toString()) 
				|| (StringUtils.isEmpty(resolved.toString().replace("*", ""))))
		{
        	// Rules on an empty resolved
        	emptyResolvedRules(input);
		}
        
		return resolved.toString();
	}
}
