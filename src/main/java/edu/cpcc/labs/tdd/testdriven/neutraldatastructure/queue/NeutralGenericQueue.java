package edu.cpcc.labs.tdd.testdriven.neutraldatastructure.queue;

import edu.cpcc.labs.tdd.testdriven.neutraldatastructure.DataNode;

public class NeutralGenericQueue <T> {
	
	private DataNode<T> head; // this pointer is riveted to the first node
	private DataNode<T> tail; // this is the moving cursor...
	private int size;         // running count of nodes
	
	public NeutralGenericQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	
	// NOTE: 
	// In this case, the growth of the queue is forward - with head always pointing to the first inserted element...
	// This is to conform with the FIFO model for a Queue...
	public void add(T value) throws Exception {
		DataNode<T> newDataNode = new DataNode<T>();
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

	public T remove() throws Exception {
		if (empty()) throw new Exception ("Cannot remove from an empty queue");
		T value = this.head.getData();
		DataNode<T> temp = head;
		this.head = this.head.getNext();
		// ground the previous head node...may help with garbage collection...
		temp.setNext(null);
		this.size--;
		return value;
	}

	public Integer size() {
		return this.size;
	}

	public boolean empty() {
		return (head == null);
	}

	public T peek() {
		if (empty()) return null;
		return this.head.getData();
	}	
	
	
}
