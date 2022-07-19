package edu.cpcc.labs.tdd.testdriven;

public class NeutralIntegerStack {
	
	IntegerDataNode topOfStack;
		
	public NeutralIntegerStack() {
		this.topOfStack = null;
	}

	public void push(Integer valueToPush) {
		
		IntegerDataNode newIntegerDataNode = new IntegerDataNode();
		newIntegerDataNode.setData(valueToPush);
		
		// if this is the first data insertion...
		if(topOfStack == null) {
			this.topOfStack = newIntegerDataNode;
		}else {
			IntegerDataNode current = this.topOfStack;
			this.topOfStack = newIntegerDataNode;
			this.topOfStack.setPrevious(current);			
		}
	}

	public Integer peek() {
		return topOfStack.getData();
	}

	public Integer pop() {
		
		Integer data = this.topOfStack.getData();
		
		IntegerDataNode current = this.topOfStack;
		this.topOfStack = topOfStack.getPrevious();
		current.setNext(null);
		
		return data;
		
	}
	
	public boolean empty() { 
		// NOTE: this is not equality but a conditional statement...
		return (topOfStack == null);
	}

}
