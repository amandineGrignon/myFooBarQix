package fr.agrignon.foobarqix;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

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
	
	public static String compute(String source) {
		
		// To build the string
        StringBuilder sb = new StringBuilder();
		
        // To convert the source to integer
		int number = Integer.parseInt(source);
	
		// "is divisible by" rules
		for (Map.Entry<Integer, String> entry : FOOBARQIX_RULES.entrySet()) {
			if ((number % entry.getKey()) == 0)
				sb.append(entry.getValue());
		}
		
		return sb.toString();
	}
	
}
