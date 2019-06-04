package fr.agrignon.foobarqix;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FooBarQixTests {

	@Test
	public void compute_ShouldWriteFoo_WhenNumberIsDivisibleBy3() {
		// Assert
		String number = "6";
		
		// Act
		String result = FooBarQix.compute(number);
		
		// Arrange
		assertThat(result).isEqualTo("Foo");
	}
	
	@Test
	public void compute_ShouldWriteBar_WhenNumberIsDivisibleBy5() {
		// Assert
		String number = "10";
		
		// Act
		String result = FooBarQix.compute(number);
		
		// Arrange
		assertThat(result).isEqualTo("Bar");
	}
	
	@Test
	public void compute_ShouldWriteQix_WhenNumberIsDivisibleBy7() {
		// Assert
		String number = "14";
		
		// Act
		String result = FooBarQix.compute(number);
		
		// Arrange
		assertThat(result).isEqualTo("Qix");
	}
}
