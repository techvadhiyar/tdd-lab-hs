package edu.cpcc.labs.tdd.testdriven.neutraldatastructure.queue;

import edu.cpcc.labs.tdd.testdriven.neutraldatastructure.IntegerDataNode;

//NOTE: if you design it this way then you will need to create a separate class for each data type...
//NOTE: and hence the switch to generics in the next case...
public class NeutralIntegerQueue {
	
	private IntegerDataNode head;
	private IntegerDataNode tail; // useful for appending...
	private int size; // running count of nodes
	
	public NeutralIntegerQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	// NOTE: 
	// In this case, the growth of the queue is forward - with head always pointing to the first inserted element...
	// This is to conform with the FIFO model for a Queue...
	public void add(Integer value) throws Exception {
		IntegerDataNode newDataNode = new IntegerDataNode();
		newDataNode.setData(value);
		if(this.head == null) {
			// add first node ...
			this.head = newDataNode;
			this.tail = newDataNode;
		}else if (head == tail) {
			// add second node...
			this.head.setNext(newDataNode);
			this.tail = newDataNode;
		}else {
			this.tail.setNext(newDataNode);
			this.tail = newDataNode;
		}
		this.size++;

	}

	public Integer remove() throws Exception {
		if (empty()) throw new Exception ("Cannot remove from an empty queue");
		Integer value = this.head.getData();
		IntegerDataNode temp = head;
		this.head = this.head.getNext();
		// ground the previous head node...may help with garbage collection...
		temp.setNext(null);
		this.size--;
		return value;
	}

	public int size() {
		return this.size;
	}

	public boolean empty() {
		return (head == null);
	}

	public Integer peek() {
		if (empty()) return null;
		return this.head.getData();
	}	
			

}
