package fr.agrignon.foobarqix;

import java.text.MessageFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFooBarQixApplication {

	/** 
	 * Show errors on the console if arguments are missing
	 */
	private static void showErrorsArgumentMissing() {		
		System.err.println("Argument is missing, please run the program with these arguments :");
		System.err.println("-s1 [following by numbers] (to use the compute method from the step 1)");
		System.err.println("-s2 [following by numbers] (to use the compute method from the step 2)");
        System.exit(1);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MyFooBarQixApplication.class, args);
		
		if (args.length > 1) {
			for(int i = 1; i < args.length; i++) {
				// Call compute method from FooBarQix
			    String result = FooBarQix.compute(args[i]);
			    
			    System.out.format("%s => %s%n", args[i], result);	
			}
		} else {
			showErrorsArgumentMissing();
		}
	}

}
