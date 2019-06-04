package fr.agrignon.foobarqix;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FooBarQixTests {

	@Test
	public void compute_ShouldWriteFoo_WhenNumberIsDivisibleBy3() {
		
		String number = "6";
		FooBarQix fbq = new FooBarQix();
		
		String result = fbq.compute(number);
		
		assertThat(result).isEqualTo("Foo");
	}
}
