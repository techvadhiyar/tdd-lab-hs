package edu.cpcc.labs.tdd.testdriven;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	void testFirstPushToIntegerStack() {
		NeutralIntegerStack neutralStack = new NeutralIntegerStack();
		Integer valueToPush = 10;
		neutralStack.push(valueToPush);
		assertEquals(valueToPush, neutralStack.peek());		
	}
	
	@Test
	void testPushToNonEmptyStack() {
		NeutralIntegerStack neutralStack = new NeutralIntegerStack();
		Integer firstValueToPush = 10, secondValueToPush = 20;
		
		neutralStack.push(firstValueToPush);
		neutralStack.push(secondValueToPush);
		
		// Expect 20 since the top of the stack is pointing to 20...
		assertEquals(secondValueToPush, neutralStack.peek());			
	}
	
	
	@Test
	void testPopFromSingleValueIntegerStack() {
		NeutralIntegerStack neutralStack = new NeutralIntegerStack();
		Integer firstValueToPush = 10;
		
		neutralStack.push(firstValueToPush);
		
		Integer poppedValue = neutralStack.pop();
		assertEquals(firstValueToPush,poppedValue);
		
		// the stack should be empty it was just a single value stack...
		assertTrue(neutralStack.empty());		
		
	}
	
	
}
