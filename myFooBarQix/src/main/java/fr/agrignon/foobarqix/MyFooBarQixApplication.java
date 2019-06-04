package fr.agrignon.foobarqix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFooBarQixApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFooBarQixApplication.class, args);
		
		if (args.length > 0) {
			for (String arg : args) {
				// Call compute method from FooBarQix
			    String result = FooBarQix.compute(arg);
			    
			    System.out.format("%s => %s%n", arg, result);	
			}
		} else {
			System.err.println("Argument is missing.");
	        System.exit(1);
		}
	}

}
