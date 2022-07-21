package edu.cpcc.labs.tdd.testdriven.neutraldatastructure.queue;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GenericsNeutralIntegerQueueTest {

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}
	
	// Happy Path
	@Test
	public void testAddToQueue() {
		NeutralGenericQueue<Integer> queue = new NeutralGenericQueue<>();		
		Integer valueToAdd = 10;
		try {
			queue.add(valueToAdd);
			// This test case will lead you to code the peek() method since this is need
			// to pass the case. 
			assertEquals(valueToAdd, queue.peek());
			// this method will also lead you to code the size() method since it is needed 
			// to pass this test case.
			assertEquals(1, queue.size());
		}catch (Exception e) {
			fail("Failed with an exception " + e.getMessage());
		}		
	}
	
	// Edge Case
	@Test
	public void testAddToFullQueue() {
		// NOTE: this test case will fail, then lead you to code the full() method and then 
		// call the full method from the add method as a toll gate check.
		NeutralGenericQueue<Integer> queue = new NeutralGenericQueue<Integer>();
		try {
			queue.add(10);
			queue.add(20);
			// expect an exception when the third add is attempted.
			queue.add(30);
		}catch (Exception e) {
			assertEquals("Queue overflow", e.getMessage());
			assertThat(e.getMessage(), equalTo("Queue overflow"));
		}
	}
	
	// Happy path..
	@Test
	public void testRemoveFromQueue() {
		NeutralGenericQueue<Integer> queue = new NeutralGenericQueue<Integer>();		
		try {
			queue.add(10);
			queue.add(20);
			queue.remove();
			int expectedSize = 1;
			Integer expectedRemainderValue = 20;
			assertEquals(expectedSize, queue.size());
			assertEquals(expectedRemainderValue, queue.peek());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Got an unexpected exception for the happy path.");
		}		
	}
	
	// Edge Case
	@Test
	public void testRemoveFromEmptyQueue() {
		// This test case will lead you to code the empty() method in MyQueue to support this test.
		NeutralGenericQueue<Integer> queue = new NeutralGenericQueue<Integer>();
		try {
			queue.remove();			
		}catch (Exception e) {
			assertThat(e.getMessage(), equalTo("Cannot remove from an empty queue"));
		}
	}
	
	// You can continue to add more tests...

}
