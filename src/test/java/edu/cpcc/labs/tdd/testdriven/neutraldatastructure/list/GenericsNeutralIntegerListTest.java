package edu.cpcc.labs.tdd.testdriven.neutraldatastructure.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GenericsNeutralIntegerListTest {

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
	public void testAddToList() {
		NeutraGenericlList<Integer> list = new NeutraGenericlList<>();		
		Integer valueToAdd = 10;
		try {
			list.add(valueToAdd);
			// This test case will lead you to code the get() method since this is need
			// to pass the case. 
			assertEquals(valueToAdd, list.get(0));
			// this method will also lead you to code the size() method since it is needed 
			// to pass this test case.
			assertEquals(1, list.size());
		}catch (Exception e) {
			fail("Failed with an exception " + e.getMessage());
		}		
	}
	
	// Happy path..
	@Test
	public void testRemoveFromList() {
		NeutraGenericlList<Integer> list = new NeutraGenericlList<>();		
		try {
			list.add(10);
			list.add(20);
			list.remove(0);
			int expectedSize = 1;
			Integer expectedRemainderValue = 20;
			assertEquals(expectedSize, list.size());
			assertEquals(expectedRemainderValue, list.get(0));
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Got an unexpected exception for the happy path.");
		}		
	}
	
	// Happy Path
	@Test
	public void testRemoveAll() {
		// This test case will lead you to code the empty() method in MyQueue to support this test.
		NeutraGenericlList<Integer> list = new NeutraGenericlList<>();
		try {
			list.add(10);
			list.add(20);
			list.add(30);
			list.remove();
			assertEquals(0, list.size());
		}catch (Exception e) {
			fail("Got an unexpected exception for the happy path.");
		}
		
	}
	
	// Edge Case'
	@Test
	public void testRemoveFromEmptyList() {
		// This test case will lead you to code the empty() method in MyQueue to support this test.
		NeutraGenericlList<Integer> list = new NeutraGenericlList<>();
		try {
			list.remove();			
		}catch (Exception e) {
			assertEquals(e.getMessage(), "Cannot remove from an empty collection.");
		}
	}
	
	// Insert
	// Happy Path
	@Test
	public void testInsertIntoList() {
		NeutraGenericlList<Integer> list = new NeutraGenericlList<>();	
		Integer valueToInsert = 15;
		try {
			list.add(10);
			list.add(20);
			list.add(30);
			list.add(valueToInsert, 1);
			// This test case will lead you to code the get() method since this is need
			// to pass the case. 
			assertEquals(valueToInsert, list.get(1));
			// this method will also lead you to code the size() method since it is needed 
			// to pass this test case.
			assertEquals(4, list.size());
		}catch (Exception e) {
			fail("Failed with an exception " + e.getMessage());
		}		
	}
	
	// You can continue to add more tests...

}
