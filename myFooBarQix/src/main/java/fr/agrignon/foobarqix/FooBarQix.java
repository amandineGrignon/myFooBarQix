package fr.agrignon.foobarqix;

import java.text.MessageFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

public class FooBarQix {

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
	 * Implements the following rules :
	 * 
	 * If the number is divisible by 3, write “Foo” instead of the number
	 * If the number is divisible by 5, add “Bar”
	 * If the number is divisible by 7, add “Qix”
	 * For each digit 3, 5, 7, add “Foo”, “Bar”, “Qix” in the digits order.
	 * 
	 * @param source
	 * @return result
	 */
	public static String compute(String source) {
		
		// To build the string
        StringBuilder sb = new StringBuilder();
		
        // To convert the source to integer
		int number = Integer.parseInt(source);
		
		if (number < 0) {
			throw new IllegalArgumentException(MessageFormat.format("{0} is out of bounds", source));
		}
	
		// "is divisible by" rules
		for (Map.Entry<Integer, String> entry : FOOBARQIX_RULES.entrySet()) {
			if ((number % entry.getKey()) == 0)
				sb.append(entry.getValue());
		}
		
		// Check content of the source string
		for (char c : source.toCharArray()) {
			for (Map.Entry<Integer, String> entry : FOOBARQIX_RULES.entrySet()) {
				if (c == String.valueOf(entry.getKey()).charAt(0))
				{
					sb.append(entry.getValue());
				}
			}
		}
		
		// Write the source number if the result is empty
		if (StringUtils.isEmpty(sb.toString()))
		{
			return source;
		}
		
		return sb.toString();
	}
	
	/**
	 * Implements the following rules:
	 * 
	 * Use the rules of the compute method
	 * And keep a trace of 0 in numbers, each 0 must be replace par char “*“
	 * 
	 * @param source
	 * @return result
	 */
	public static String computeSecondStep(String source) {
		
		return null;
	}
}
