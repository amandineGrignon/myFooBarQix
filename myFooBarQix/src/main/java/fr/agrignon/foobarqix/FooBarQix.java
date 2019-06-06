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
	 * To convert the source to integer
	 * 
	 * @param source
	 * @return number
	 */
	private static Integer checkNumber(String source) {
		Integer number = Integer.valueOf(source);
		
		if (number < 0) {
			throw new IllegalArgumentException(MessageFormat.format("{0} is out of bounds", source));
		}
		
		return number;
	}
	
	/***
	 * "is divisible by" rules
	 * 
	 * @param number
	 * @return sb
	 */
	private static StringBuilder divisibleRules(Integer number) {
		// To build the string
        StringBuilder sb = new StringBuilder();
		
		// "is divisible by" rules
		for (Map.Entry<Integer, String> entry : FOOBARQIX_RULES.entrySet()) {
			if ((number % entry.getKey()) == 0)
				sb.append(entry.getValue());
		}
		
		return sb;
	}
	
	/***
	 * Check content of the source string
	 * 
	 * @param source
	 * @param sb
	 * @return sb
	 */
	private static StringBuilder checkContentString(String source, StringBuilder sb) {
		for (char c : source.toCharArray()) {
			for (Map.Entry<Integer, String> entry : FOOBARQIX_RULES.entrySet()) {
				if (c == String.valueOf(entry.getKey()).charAt(0))
				{
					sb.append(entry.getValue());
				}
			}
			
			if (c == '0') {
				sb.append('*');
			}
		}
		
		return sb;
	}
	
	/**
	 * Write the source number if the result is empty
	 * 
	 * @param sb
	 * @param source
	 * @return sb
	 */
	private static StringBuilder checkIfEmptyString(StringBuilder sb, String source) {
		if (StringUtils.isEmpty(sb.toString()) 
				|| (StringUtils.isEmpty(sb.toString().replace("*", ""))))
		{
			sb = new StringBuilder();
			for (char c : source.toCharArray()) {
				if (c == '0')
					sb.append('*');
				else
					sb.append(c);
			}
		}
		
		return sb;
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
	public static String compute(String source) {		
	
		// Check number
        Integer number = checkNumber(source);
        
        // Divisible rules
        StringBuilder sb = divisibleRules(number);
	
		// Check content of the source string
		sb = checkContentString(source, sb);
		
		// Write the source number if the result is empty
		sb = checkIfEmptyString(sb, source);
		
		return sb.toString();
	}
}
