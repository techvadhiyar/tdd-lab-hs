package edu.cpcc.labs.tdd.testdriven.neutraldatastructure.stack;

import edu.cpcc.labs.tdd.testdriven.neutraldatastructure.DataNode;
import edu.cpcc.labs.tdd.testdriven.neutraldatastructure.IntegerDataNode;

// NOTE: if you design it this way, you will need to create a class for each data type
// NOTE: and therefore the switch to generics in the next example...
public class NeutralGenericStack <T> {
	
	DataNode<T> topOfStack;

	public NeutralGenericStack () {
		this.topOfStack = null;
	}

	// NOTE: 
	// In this case, the growth of the stack is backwards - with topOfStack always pointing to the Last inserted element...
	// ...you can also have a forward growing stack as long as topOfStack points to the last inserted element...
	// This is to conform with the LIFO model for a Stack...
	public void push(T value) throws Exception {

		// Lets say null values are not accepted...
		if (value == null) throw new Exception ("Invalid value - NULL");

		// NOTE: no size limit..unlike arrays...

		// create a new Data Node
		DataNode<T> newDataNode = new DataNode<T>();
		newDataNode.setData(value);

		// if this is the first data point...
		if (topOfStack == null) {
			topOfStack = newDataNode;			
		}else {
			DataNode<T> current = topOfStack;
			topOfStack = newDataNode;
			topOfStack.setNext(current);
		}
	}

	public T pop() throws Exception {

		// if stack is already empty...
		if(empty()) throw new Exception ("Cannot pop from an empty stack");

		T valueAtTop = topOfStack.getData();

		DataNode<T> temp = topOfStack;
		topOfStack = topOfStack.getNext();
		// ground this node previously pointed to by the topOfStack..
		temp.setNext(null); // may help with garbage collection ...

		return valueAtTop;
	} 

	public boolean empty() { 
		// NOTE: this is not equality but a conditional statement...
		return (topOfStack == null);
	}

	public T peek() throws Exception {

		if (empty()) throw new Exception("Cannot peek into an empty stack");

		return topOfStack.getData();

	}

	public boolean contains(Integer value) throws Exception {

		if(empty()) throw new Exception ("Cannot search and empty stack");

		boolean done = false, found = false;

		// Don't mess with the topOfStack...use a transient reference...
		DataNode<T> cursor = topOfStack;

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
