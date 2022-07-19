package edu.cpcc.labs.tdd.testbased;

public class HelloWorld {
		
	public String sayHelloTo(String userName) {
		
		if (userName == null) throw new NullPointerException("userName was null");
		StringBuilder builder = new StringBuilder();
		builder.append("Hello ");
		builder.append(userName);
		return builder.toString();
	}

}
