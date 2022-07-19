package edu.cpcc.labs.tdd.testbased;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArithmeticCalculatorTest {
	
	static ArithmeticCalculator calculator;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		calculator = new ArithmeticCalculator();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Test Divide for happy path")
	void testDivideHappyPath() {
		
		Double numerator = 10.0;
		Double denominator = 5.0;
		
		Double expectedValue = 2.0;
		
		Double receivedValue = calculator.divide(numerator, denominator);
		
		assertEquals(expectedValue, receivedValue);
		
		
	}
	
	
	// Unhappy path test...
	@Test
	@DisplayName("Test Divide by Zero for Double values.")
	void testDivideByZeroDouble() {
		
		// NOTE: 
		// https://stackoverflow.com/questions/2381544/why-doesnt-java-throw-an-exception-when-dividing-by-0-0
		double numerator = 10.0;
		double denominator = 0.0;
		assertEquals(Double.POSITIVE_INFINITY, calculator.divide(numerator, denominator));		
	}
	
	
	// Unhappy path test...
	@Test
	@DisplayName("Test Divide by Zero for Integer values.")
	void testDivideByZeroInteger() {

		// NOTE: 
		// https://stackoverflow.com/questions/2381544/why-doesnt-java-throw-an-exception-when-dividing-by-0-0
		Integer numerator = 10;
		Integer denominator = 0;
		assertThrows(ArithmeticException.class, ()->calculator.divide(numerator, denominator));		
	}


}
