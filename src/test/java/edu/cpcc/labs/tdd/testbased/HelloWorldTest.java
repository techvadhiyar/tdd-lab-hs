package edu.cpcc.labs.tdd.testbased;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloWorldTest {
	
	// NOTE: class under test...a Singleton instance....
	static HelloWorld helloWorld;

	// NOTE: implies before all test cases are run....
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		helloWorld = new HelloWorld();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	// NOTE: implies before each test method is run...
	@BeforeEach
	void setUp() throws Exception {
		// helloWorld  = new HelloWorld();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	// NOTE: if you want to disable your test case for now use, this annotation
	// @Disabled
	@Test
	@DisplayName("Testing the happy path")
	void testHappyPath() {
		
		// create an instance of the class to test...
		// HelloWord helloWorld = new HelloWord();
		
		// setup the test case with data....
		String personName = "Joe";
		String expectedSalutation = "Hello Joe";
		
		// execute the test...
		String receivedSaluation = helloWorld.sayHelloTo(personName);
		
		// compare the expected value with the received value...
		assertEquals(expectedSalutation, receivedSaluation);		
		
	}
	
	// Unhappy path test...
	@Test
	@DisplayName("Testing for Null inputs")
	void testForNullInputs() {
		
		// create an instance of the class to test...
		// HelloWord helloWorld = new HelloWord();
		
		// setup the test case with data....
		String personName = null;
		
		// execute the test...
		// NOTE: the second arg is a Lambda function....
		assertThrows(NullPointerException.class, 
				     ()->{ 
				    	 helloWorld.sayHelloTo(personName); 
				         }
				     );	
		// NOTE: 
		// assertThrows(NullPointerException.class,  helloWorld.sayHelloTo(personName)); 
		
	}
	

}
