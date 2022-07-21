package edu.cpcc.labs.tdd.testdriven.neutraldatastructure.list;

import edu.cpcc.labs.tdd.testdriven.neutraldatastructure.IntegerDataNode;

// NOTE: if you design it this way then you will need to create a separate class for each data type...
// NOTE: and hence the switch to generics in the next case...
public class NeutralIntegerList {
	
	IntegerDataNode head; // fixed at the first node...
	IntegerDataNode tail; // keeps moving...useful for appending...	
	private int size; // running count of nodes...
	
	public NeutralIntegerList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	// Append...
	public void add(Integer value) throws Exception {
		// include this edge case as an example for data validation...DELA will look for it.
		if (value == null) throw new Exception ("Null values not accepted.");
		
		if (empty()) {
			// Scenario - empty list - adding the very first data node...
			IntegerDataNode newDataNode = new IntegerDataNode();
			newDataNode.setData(value);
			this.head = newDataNode;
			this.tail = newDataNode;			
		}else if(head == tail) {
			// Scenario - adding the second data node...
			IntegerDataNode newDataNode = new IntegerDataNode();
			newDataNode.setData(value);
			this.tail = newDataNode;
			this.head.setNext(newDataNode);
		}else {
			// Scenario - adding the third data node and beyond...head is no longer involved....
			IntegerDataNode newDataNode = new IntegerDataNode();
			newDataNode.setData(value);
			this.tail.setNext(newDataNode);
			this.tail = newDataNode;
		}
		this.size++;
	}

	// Insert At....always start from 0....since the starting node index is 0 
	public void add(Integer value, int index) throws Exception {	
		if (value == null) throw new Exception ("Null values not accepted.");
		// if you have an empty list or if the index position > size....treat it as an append....
		if (this.empty() || index > this.size()) {
			add(value);			
		}
		// else if index position = 0 then insert before the head...in this case the new node becomes the head...
		else if (index == 0) {
			// leave the tail as is...
			IntegerDataNode newDataNode = new IntegerDataNode();
			newDataNode.setData(value);
			newDataNode.setNext(this.head);
			this.head = newDataNode;
			this.size++;
		}
		// else this is an in-between insert....leave head and tail out of it....use transient nodes...
		else {
			IntegerDataNode dataNodeAtPosition = this.dataNodeAt(index);
			IntegerDataNode dataNodeBeforePosition = this.dataNodeAt(index-1);			
			IntegerDataNode newDataNode = new IntegerDataNode();
			newDataNode.setData(value);
			newDataNode.setNext(dataNodeAtPosition);
			dataNodeBeforePosition.setNext(newDataNode);		
			if (index-1 == 0) this.head.setNext(newDataNode);
			else dataNodeBeforePosition.setNext(newDataNode);
			this.size++;
		}
		
	}

	public void remove(int index) throws Exception {
		if (empty()) throw new Exception ("Cannot remove from an empty collection.");		
		if (index == 0) {
			// remove first node....so move head to the second node...
			IntegerDataNode temp = this.head.getNext();
			// ground current head...
			this.head.setNext(null);
			this.head = temp;
		}else if (index < this.size){
			// remove any node in between...
			IntegerDataNode dataNodeAtPosition = this.dataNodeAt(index);
			IntegerDataNode dataNodeBeforePosition = this.dataNodeAt(index-1);
			dataNodeBeforePosition.setNext(dataNodeAtPosition.getNext());
			// ground this node...
			dataNodeAtPosition.setNext(null);
		}else if (index >= this.size) {
			// remove the last node...move tail to the previous node..
			this.tail = this.dataNodeAt(this.size-1);
			this.tail.setNext(null);			
		}else {
			throw new Exception ("Ambigious index...exiting");
		}
		this.size --;
	}

	public void remove() throws Exception {
		if (empty()) throw new Exception ("Cannot remove from an empty collection."); 
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	private IntegerDataNode dataNodeAt(int index) throws Exception {		
		if (empty()) throw new Exception ("Empty collection.");		
		IntegerDataNode cursor = null;
		// if index = 0, then cursor is the head or the first node...
		if (index == 0) {
			cursor = this.head;
		}
		else {
			// initialize cursor to head.
			cursor = head;
			for (int i=0; i < index; i++) {
				// If I have already reached the end of the list...then don't fall over the cliff....
				if (cursor.getNext() != null) {
					cursor = cursor.getNext();
				}
			}
		}		
		return cursor;
	}
		

	public Integer get(int index) throws Exception {
		if (empty()) throw new Exception ("Cannot get from an empty collection.");
		IntegerDataNode dataNode = this.dataNodeAt(index);
		return dataNode.getData();
	}

	public Integer[] get() throws Exception {
		if (empty()) throw new Exception ("Cannot get from an empty collection.");
		IntegerDataNode cursor = this.head;
		Integer[] values = new Integer[this.size];
		for (int i=0; i < this.size; i ++) {
			Integer value = cursor.getData();
			values[i] = value;
			cursor = cursor.getNext();
		}		 
		return values;		 
	}

	public int size() {
		return this.size;
	}

	public boolean empty() {
		return (head == null);
	}

	public boolean contains(Integer value) throws Exception {
		if (empty()) throw new Exception ("Cannot search in an empty collection.");
		boolean done = false, found = false;
		IntegerDataNode cursor = this.head;
		while (!done) {
			if (cursor == null) {
				done = true;
			}else if (cursor.getData() == value) {
				done = true;
				found = true;
			}else {
				cursor = cursor.getNext();
			}
		}
		// return the final value of found...
		return found;
	}

}
