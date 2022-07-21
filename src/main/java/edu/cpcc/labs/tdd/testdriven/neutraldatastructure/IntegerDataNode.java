package edu.cpcc.labs.tdd.testdriven.neutraldatastructure;

public class IntegerDataNode {
	
	// Data point...
	private Integer data;
	
	// reference to the next data node...
	IntegerDataNode next;
	
	// reference to the previous data node...
	IntegerDataNode previous;
	
	
	public IntegerDataNode() {
		this.data = null;
		this.next = null;
		this.previous = null;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public IntegerDataNode getNext() {
		return next;
	}

	public void setNext(IntegerDataNode next) {
		this.next = next;
	}

	public IntegerDataNode getPrevious() {
		return previous;
	}

	public void setPrevious(IntegerDataNode previous) {
		this.previous = previous;
	}

}
