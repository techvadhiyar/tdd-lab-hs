package edu.cpcc.labs.tdd.mocks.messaging;

public interface MessagingService {
	public boolean send(String message);
	public String receive();
	
}
