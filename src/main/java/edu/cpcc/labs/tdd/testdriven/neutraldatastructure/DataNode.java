package edu.cpcc.labs.tdd.testdriven.neutraldatastructure;

public class DataNode <T> {
	
	// Data point...
	private T data;
	
	// reference to the next data node...
	DataNode<T> next;
	
	// reference to the previous data node...
	DataNode<T> previous;
	
	
	public DataNode() {
		this.data = null;
		this.next = null;
		this.previous = null;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DataNode<T> getNext() {
		return next;
	}

	public void setNext(DataNode<T> next) {
		this.next = next;
	}

	public DataNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DataNode<T> previous) {
		this.previous = previous;
	}

}
