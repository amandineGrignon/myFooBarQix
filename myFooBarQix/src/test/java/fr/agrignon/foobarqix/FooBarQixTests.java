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
	
	@Test
	public void compute_ShouldWriteNumber_WhenNumberIsNotDivisibleByNumberRules() {
		// Assert
		String number = "2";
		
		// Act
		String result = FooBarQix.compute(number);
		
		// Arrange
		assertThat(result).isEqualTo("2");
	}
	
	@Test
	public void compute_ShouldWriteFooFoo_WhenNumberIs3() {
		// Assert
		String number = "3";
		
		// Act
		String result = FooBarQix.compute(number);
		
		// Arrange
		assertThat(result).isEqualTo("FooFoo");
	}
	
	@Test
	public void compute_ShouldWriteBarBar_WhenNumberIs5() {
		// Assert
		String number = "5";
		
		// Act
		String result = FooBarQix.compute(number);
		
		// Arrange
		assertThat(result).isEqualTo("BarBar");
	}
	
	@Test
	public void compute_ShouldWriteQixQix_WhenNumberIs7() {
		// Assert
		String number = "7";
		
		// Act
		String result = FooBarQix.compute(number);
		
		// Arrange
		assertThat(result).isEqualTo("QixQix");
	}
	
	@Test
	public void compute_ShouldAddFoo_WhenNumberContains3() {
		// Assert
		String number = "13";
		
		// Act
		String result = FooBarQix.compute(number);
		
		// Arrange
		assertThat(result).isEqualTo("Foo");
	}
	
	@Test
	public void compute_ShouldAddBar_WhenNumberContains5() {
		// Assert
		String number = "51";
		
		// Act
		String result = FooBarQix.compute(number);
		
		// Arrange
		assertThat(result).isEqualTo("FooBar");
	}
	
	@Test
	public void compute_ShouldAddQix_WhenNumberContains7() {
		// Assert
		String number = "27";
		
		// Act
		String result = FooBarQix.compute(number);
		
		// Arrange
		assertThat(result).isEqualTo("FooQix");
	}
	
	@Test
	public void compute_ShouldWriteFooBarBar_WhenNumberDivisibleBy3And5AndContains5() {
		// Assert
		String number = "15";
		
		// Act
		String result = FooBarQix.compute(number);
		
		// Arrange
		assertThat(result).isEqualTo("FooBarBar");
	}
	
}
