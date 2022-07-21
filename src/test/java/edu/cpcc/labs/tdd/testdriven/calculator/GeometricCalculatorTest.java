package edu.cpcc.labs.tdd.testdriven.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.cpcc.labs.tdd.testdriven.calculator.GeometricCalculator;

class GeometricCalculatorTest {
	
	// Class under test....
	static GeometricCalculator geometricCalculator;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		geometricCalculator = new GeometricCalculator();
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
	@DisplayName("Test area of a circle in the happy path")
	void testAreaOfCircle() {
		geometricCalculator = new GeometricCalculator();		
		// Setup my test case...
		Double radius = 10.0;
		Double expectedArea = Math.PI * Math.pow(10, 2);
		// execution...
		Double receivedArea = geometricCalculator.areaOfCircle(radius);	
		// validation...
		assertEquals(expectedArea, receivedArea);		
	}

}
