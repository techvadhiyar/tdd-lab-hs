package edu.cpcc.labs.tdd.mocks.messaging;

public class MessagingController {
	
	private MessagingService smsService;
	
	public MessagingController(MessagingService smsService) {
		this.smsService = smsService;
	}
	
	public Boolean sendSMS(String message) {
		return this.smsService.send(message);
	}
}
