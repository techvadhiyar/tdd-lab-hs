package edu.cpcc.labs.tdd.testdriven.neutraldatastructure.stack;

import edu.cpcc.labs.tdd.testdriven.neutraldatastructure.IntegerDataNode;

// NOTE: if you design it this way, you will need to create a class for each data type
// NOTE: and therefore the switch to generics in the next example...
public class NeutralIntegerStack {
	
	IntegerDataNode topOfStack;

	public NeutralIntegerStack() {
		this.topOfStack = null;
	}

	// NOTE: 
	// In this case, the growth of the stack is backwards - with topOfStack always pointing to the Last inserted element...
	// ...you can also have a forward growing stack as long as topOfStack points to the last inserted element...
	// This is to conform with the LIFO model for a Stack...
	public void push(Integer value) throws Exception {

		// Lets say null values are not accepted...
		if (value == null) throw new Exception ("Invalid value - NULL");

		// NOTE: no size limit..unlike arrays...

		// create a new Data Node
		IntegerDataNode newDataNode = new IntegerDataNode();
		newDataNode.setData(value);

		// if this is the first data point...
		if (topOfStack == null) {
			topOfStack = newDataNode;			
		}else {
			IntegerDataNode current = topOfStack;
			topOfStack = newDataNode;
			topOfStack.setNext(current);
		}
	}

	public Integer pop() throws Exception {

		// if stack is already empty...
		if(empty()) throw new Exception ("Cannot pop from an empty stack");

		Integer valueAtTop = topOfStack.getData();

		IntegerDataNode temp = topOfStack;
		topOfStack = topOfStack.getNext();
		// ground this node previously pointed to by the topOfStack..
		temp.setNext(null); // may help with garbage collection ...

		return valueAtTop;
	} 

	public boolean empty() { 
		// NOTE: this is not equality but a conditional statement...
		return (topOfStack == null);
	}

	public Integer peek() throws Exception {

		if (empty()) throw new Exception("Cannot peek into an empty stack");

		return topOfStack.getData();

	}

	public boolean contains(Integer value) throws Exception {

		if(empty()) throw new Exception ("Cannot search and empty stack");

		boolean done = false, found = false;

		// Don't mess with the topOfStack...use a transient reference...
		IntegerDataNode cursor = topOfStack;

		// Navigate through the stack - top to bottom....
		while (!done) {
			if (cursor == null) {
				// still not found but we've reached the end of the cliff...don't fall..
				done = true;				
			}else if (cursor.getData() == value) {
				found = true;
				done  = true;
			}else {
				cursor = cursor.getNext();
			}
		}

		return found;

	}
		
		


}
