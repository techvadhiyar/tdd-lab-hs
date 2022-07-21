package edu.cpcc.labs.tdd.testdriven.neutraldatastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import edu.cpcc.labs.tdd.testdriven.neutraldatastructure.stack.NeutralGenericStack;

class NeutralIntegerStackTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
	public void testPushToStack() {
		NeutralIntegerStack stack = new NeutralIntegerStack();		
		Integer valueToAdd = 10;
		try {
			stack.push(valueToAdd);
			// This test case will lead you to code the peek() method since this is need
			// to pass the case. 
			assertEquals(valueToAdd, stack.peek());
			// this method will also lead you to code the size() method since it is needed 
			// to pass this test case.
			// assertEquals(1, stack.size());
		}catch (Exception e) {
			fail("Failed with an exception " + e.getMessage());
		}		
	}
	
	@Test
	public void testPopFromStack() {
		NeutralIntegerStack stack = new NeutralIntegerStack();	
		try {
			stack.push(10);
			stack.push(20);
			stack.pop();
			Integer expectedRemainderValue = 10;
			assertEquals(expectedRemainderValue, stack.peek());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Got an unexpected exception for the happy path.");
		}		
	}
	
	@Test
	public void testContainsInStack() {
		NeutralIntegerStack stack = new NeutralIntegerStack();	
		try {
			stack.push(10);
			stack.push(20);
			stack.push(30);
			assertTrue(stack.contains(20));			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Got an unexpected exception for the happy path.");
		}	
	}
	
	@Test
	public void testEmptyStack() {
		NeutralIntegerStack stack = new NeutralIntegerStack();	
		try {
			// start with an empty stack...
			assertTrue(stack.empty());
			
			// push a few elements
			stack.push(10);
			stack.push(20);
			stack.push(30);
			// then...pop them out...
			stack.pop();
			stack.pop();
			stack.pop();
			
			// re-assert that the stack is empty
			assertTrue(stack.empty());			
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Got an unexpected exception for the happy path.");
		}			
	}
	
	// Edge Case'
	@Test
	public void testPopFromEmptyStack() {
		// This test case will lead you to code the empty() method in MyQueue to support this test.
		NeutralIntegerStack stack = new NeutralIntegerStack();
		try {
			stack.pop();			
		}catch (Exception e) {
			assertEquals(e.getMessage(), "Cannot pop from an empty stack");
		}
	}
	
	// You can continue to add more tests...
	
	
}
